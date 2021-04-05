package kr.gsm.model;
// JDBC API
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MemberDAO {
   private Connection conn; //  연결객체
   private PreparedStatement ps; // SQL문장(전송객체)
   private ResultSet rs; //  select SQL->결과를 저장하는객체
   // 연결객체를 생성하는 동작
   public void getConnect() {
	   String url="jdbc:mysql://localhost:3306/gsm4"; // DB접속URL(프로토콜)
	   String user="root";
	   String password="12345";
	   //---------------------------------------------
	   //=new com.mysql.jdbc.Driver();	      
	    try {
		// 동적로딩(실행시점에서 객체를 찾고->생성)   
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url, user, password);
	    } catch (Exception e) {
		  e.printStackTrace();
	    } 
   }
   // 회원전체리스트(List<MemberVO>) 가져오기
   public List<MemberVO> memberList() {
	   String SQL="select * from member";
	   getConnect(); // conn=DB연결
	   List<MemberVO> list=new ArrayList<MemberVO>();
	   try {
		// SQL문장을 전송하는 객체를 생성(PreparedStatement, Statement)   		   
		ps=conn.prepareStatement(SQL); // 프리(먼저)컴파일->성능을 개선
		rs=ps.executeQuery(); //실행
		while(rs.next()) {
			int num=rs.getInt("num");
			String id=rs.getString("id");
			String pass=rs.getString("pass");
			String name=rs.getString("name");
			int age=rs.getInt("age");
			String phone=rs.getString("phone");
			String email=rs.getString("email");			
			// VO에 묶고
			MemberVO vo=new MemberVO();
			vo.setNum(num);
			vo.setId(id);
			vo.setPass(pass);
			vo.setName(name);
			vo.setAge(age);
			vo.setPhone(phone);
            vo.setEmail(email);
            //VO를 List에 담기
			list.add(vo);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return list;
   }   
   // 회원가입동작(Java+SQL)
   public int memberInsert(MemberVO vo) {
	   getConnect(); // conn                                               1 2 3 4 5 6
	   String SQL="insert into member(id,pass,name,age,phone,email) values(?,?,?,?,?,?)";
       int cnt=0;
	   try {
    	  ps=conn.prepareStatement(SQL); //먼저 컴파일
    	  ps.setString(1, vo.getId()); // 파라메터설정
    	  ps.setString(2,vo.getPass());
    	  ps.setString(3, vo.getName());
    	  ps.setInt(4, vo.getAge());
    	  ps.setString(5, vo.getPhone());
    	  ps.setString(6, vo.getEmail());
    	  cnt=ps.executeUpdate(); // 실행    	  
	   } catch (Exception e) {
		  e.printStackTrace();
	   }
	   return cnt;
   }
}

