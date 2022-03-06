package sns;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class SnsController
 */
@WebServlet("/SnsController")
//@MultipartConfig(maxFileSize=1024*1024*2, location="c:/Temp/img")
@MultipartConfig(maxFileSize=1024*1024*2, location="/Users/jyp/Downloads")
public class SnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	private SnsDAO dao;
	private ServletContext ctx;
	
	// 웹 리소스 기본 경로 지정
	private final String START_PAGE = "snsList.jsp";
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new SnsDAO();
		ctx = getServletContext();		
	}
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		dao = new SnsDAO();
		
		// 자바 리플렉션을 사용해 if, switch 없이 요청에 따라 구현 메서드가 실행되도록 함.
		Method m;
		String view = null;
		
		// action 파라미터 없이 접근한 경우
		if (action == null) {
			action = "snsList";
		}
		
		try {
			// 현재 클래스에서 action 이름과 HttpServletRequest 를 파라미터로 하는 메서드 찾음
			m = this.getClass().getMethod(action, HttpServletRequest.class);
			
			// 메서드 실행후 리턴값 받아옴
			view = (String)m.invoke(this, request);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			// 에러 로그를 남기고 view 를 로그인 화면으로 지정, 앞에서와 같이 redirection 사용도 가능.
			ctx.log("요청 action 없음!!");
			request.setAttribute("error", "action 파라미터가 잘못 되었습니다!!");
			view = START_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		// POST 요청 처리후에는 리디렉션 방법으로 이동 할 수 있어야 함.
		if(view.startsWith("redirect:/")) {
			// redirect/ 문자열 이후 경로만 가지고 옴
			String rview = view.substring("redirect:/".length()); //redirect:/ 문자열 이후 경로만 가져와서 페이지 이동  
			response.sendRedirect(rview);
		} else {
			// 지정된 뷰로 포워딩, 포워딩시 컨텍스트경로는 필요없음.
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);	
		}
	}

	public String addPost(HttpServletRequest request) {
		Sns n = new Sns();
		try {						
			// 이미지 파일 저장
	        Part part = request.getPart("file");
	        String fileName = getFilename(part);
	        if(fileName != null && !fileName.isEmpty()){
	            part.write(fileName);
	        }	        
	        // 입력값을 sns 객체로 매핑
			BeanUtils.populate(n, request.getParameterMap());
			
	        // 이미지 파일 이름을 sns 객체에도 저장
	        n.setImg("/img/"+fileName);

			dao.addPost(n);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("addPost 오류 ");
			request.setAttribute("error", "addPost 오류 ");
			return snsList(request);
		}
		
		return "redirect:/SnsController?action=snsList";
		
	}
	
	public String snsList(HttpServletRequest request) {
    	List<Sns> list;
		try {
			list = dao.getAllPost();
	    	request.setAttribute("snsList", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("SnsList error");
			request.setAttribute("error", "오류발생 목록 조회 실패");
		}
    	return "snsList.jsp";
    }
	
	// multipart 헤더에서 파일이름 추출
	private String getFilename(Part part) {
        String fileName = null;   
        // 파일이름이 들어있는 헤더 영역을 가지고 옴
        String header = part.getHeader("content-disposition");
        //part.getHeader -> form-data; name="img"; filename="사진5.jpg"
        System.out.println("Header => "+header);

        // 파일 이름이 들어있는 속성 부분의 시작위치를 가져와 쌍따옴표 사이의 값 부분만 가지고옴
        int start = header.indexOf("filename=");
        fileName = header.substring(start+10,header.length()-1);        
        ctx.log("파일명:"+fileName);        
        return fileName; 
	}
	
    public String getPost(HttpServletRequest request) {
        int sid = Integer.parseInt(request.getParameter("sid"));
        try {
			Sns n = dao.getPost(sid);
			request.setAttribute("post", n);
		} catch (SQLException e) {
			e.printStackTrace();
			ctx.log("getPost error ");
			request.setAttribute("error", "해당 포스트 오류발생 ");
		}

    	return "snsView.jsp";
    }
    
	public String deletePost(HttpServletRequest request) {
    	int sid = Integer.parseInt(request.getParameter("sid"));
		try {
			dao.delPost(sid);;
		} catch (SQLException e) {
			e.printStackTrace();
			ctx.log("deletePost error");
			request.setAttribute("error", "삭제오류 ");
			return snsList(request);
		}
		return "redirect:/SnsController?action=snsList";
	}
	
	public String updatePost(HttpServletRequest request) {
		Sns n = new Sns();
		try {						
			// 이미지 파일 저장
	        Part part = request.getPart("file");
	        String fileName = getFilename(part);
	        if(fileName != null && !fileName.isEmpty()){
	            part.write(fileName);
	        }	        
	        // 입력값을 sns 객체로 매핑
			BeanUtils.populate(n, request.getParameterMap());
			
	        // 이미지 파일 이름을 sns 객체에도 저장
	        n.setImg("/img/"+fileName);
	        
	        ctx.log("updatePost : "+n.getTitle()+"   sid : " + Integer.toString(n.getSid()));;
			dao.updatePost(n);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("업데이트 오류 ");
			request.setAttribute("error", "업데이트 오류 ");
			return snsList(request);
		}
		
		return "redirect:/SnsController?action=snsList";
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
