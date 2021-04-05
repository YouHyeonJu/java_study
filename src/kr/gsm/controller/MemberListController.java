package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		// (DAO)모델과 연동
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.memberList();
		// 요청한 클라이언트로 응답하기(JSP)
		// Gson API -> JSON
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    out.println("<html>"); //?
	    out.println("<body>");
	    out.println("<table border='1'>");
	    out.println("<tr>");
	    out.println("<td>번호</td>");
	    out.println("<td>아이디</td>");
	    out.println("<td>비밀번호</td>");
	    out.println("<td>이름</td>");
	    out.println("<td>나이</td>");
	    out.println("<td>전호번호</td>");
	    out.println("<td>이메일</td>");
	    out.println("</tr>");
	    for(MemberVO vo : list) {	    	
		    out.println("<tr>");
		    out.println("<td>"+vo.getNum()+"</td>");
		    out.println("<td>"+vo.getId()+"</td>");
		    out.println("<td>"+vo.getPass()+"</td>");
		    out.println("<td>"+vo.getName()+"</td>");
		    out.println("<td>"+vo.getAge()+"</td>");
		    out.println("<td>"+vo.getPhone()+"</td>");
		    out.println("<td>"+vo.getEmail()+"</td>");
		    out.println("</tr>");
	    }
	    out.println("</table>");
	    out.println("</body>");
	    out.println("</html>");
		
	}
}
