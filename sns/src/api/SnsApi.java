package api;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sns.Sns;
import sns.SnsDAO;

@Path("/sns")
public class SnsApi {

	SnsDAO dao;
	public SnsApi() {
		dao = new SnsDAO();
	}
	
	//등록
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSns(Sns sns) {
		try {
			dao.addPost(sns);
		} catch (Exception e) {
			e.printStackTrace();
			return "addPost fail";
		}
		return "addPost success";
	}
	
	//삭제
	@DELETE
	@Path("{sid}")
	public String delPost(@PathParam("sid") int sid) {
		try {
			dao.delPost(sid);
		} catch (SQLException e) {
			e.printStackTrace();
			return "SNS API:  실패 - "+ sid;
		}
		return "SNS API: 삭제!! - "+ sid;
	}
	
	//목록
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sns> getPostList() {
		List<Sns> snsList = null;
		
		try {
			snsList = dao.getAllPost();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return snsList;
	}
	
	//상세 정보
	@GET
	@Path("{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Sns getPost(@PathParam("sid") int sid) {
		Sns news = null;
		
		try {
			news = dao.getPost(sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}
	
	@PATCH
	@Path("{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updatePost(@PathParam("sid") int sid, Sns sns) {
	
		sns.setSid(sid);
		
		try {
			dao.updatePost(sns);
		} catch (Exception e) {
			e.printStackTrace();
			return "updatePost fail";
		}
		return "updatePost success";
	}
}