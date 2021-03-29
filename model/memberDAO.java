package kr.gsm.model;
import java.sql.*;
public class memberDAO {
	private Connection conn;//연결객체
	private PreparedStatement ps;//SQL 문장 전송객체
	private ResultSet rs; //select SQL 결과를 저장하는 객체
	//연결객체 생성하는 동작
	public void getConnect() {
		String url="jdbcmysql://localhost:3306/gsm4";
		String user="root";
		String password="12345";
		try {
			Class.forName("com.mysql.jdbc.Driver"); //동적로딩(실행 시점에서 객체를 찾고 생성
			DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
