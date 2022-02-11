package sns;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SnsDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	
	
	// DB 연결을 가져오는 메서드, DBCP를 사용하는 것이 좋음
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"sa","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void addPost(Sns n) throws Exception {
		Connection conn = open();
		
		String sql = "insert into sns(title,img,date,content) values(?,?,CURRENT_TIMESTAMP(),?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		
		try(conn; pstmt) {
			pstmt.setString(1, n.getTitle());
			pstmt.setString(2, n.getImg());
			pstmt.setString(3, n.getContent());
			pstmt.executeUpdate();
		}
		
	}
	

	public List<Sns> getAllPost() throws Exception {
		Connection conn = open();
		List<Sns> newsList = new ArrayList<>();
		
//		String sql = "select sid, title, PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate from sns";
		String sql = "select * from sns";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt; rs) {
			while(rs.next()) {
				Sns n = new Sns();
				n.setSid(rs.getInt("sid"));
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("date")); 
				n.setImg(rs.getString("img")); 
				n.setContent(rs.getString("content")); 
				
				newsList.add(n);
			}
			return newsList;			
		}
	}
	
	public Sns getPost(int sid) throws SQLException {
		Connection conn = open();
		
		Sns n = new Sns();
		String sql = "select sid, title, img, date, content from sns where sid=?";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sid);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs) {
			n.setSid(rs.getInt("sid"));
			n.setTitle(rs.getString("title"));
			n.setImg(rs.getString("img"));
			n.setDate(rs.getString("date"));
			n.setContent(rs.getString("content"));
			pstmt.executeQuery();
			return n;
		}
	}
	
	public void delPost(int sid) throws SQLException {
		Connection conn = open();
		
		String sql = "delete from sns where sid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setInt(1, sid);
			// 삭제된 post 없을 경우
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러");
			}
		}
	}
	
	public void updatePost(Sns n) throws Exception {
		Connection conn = open();
		
		String sql = "update sns set title = ?, img = ?, date = CURRENT_TIMESTAMP(), content = ? where sid = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		
		try(conn; pstmt) {
			pstmt.setString(1, n.getTitle());
			pstmt.setString(2, n.getImg());
			pstmt.setString(3, n.getContent());
			pstmt.setInt(4, n.getSid());
			pstmt.executeUpdate();
		}
		
	}
}
