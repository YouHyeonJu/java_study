package kr.gsm.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUrl=request.getRequestURI();
		System.out.println(reqUrl);
		String ctx=request.getContextPath();
		System.out.println(ctx);
		String command=reqUrl.substring(ctx.length());
		System.out.println(command);
		
		if (command.equals("/memberList.do")) {
			MemberDAO dao=new MemberDAO();
			List<MemberVO> list=dao.memberList();
			// 요청한 클라이언트로 응답하기(JSP)
			// Gson API -> JSON
			request.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);	
		}else if(command.equals("/memberInsert.do")) {
			request.setCharacterEncoding("utf-8"); // 2byte
			// 파라메터수집(VO)
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			
			MemberVO vo=new MemberVO();
			vo.setId(id);
			vo.setPass(pass);
			vo.setName(name);
			vo.setAge(age);
			vo.setPhone(phone);
			vo.setEmail(email);
			
			MemberDAO dao=new MemberDAO();
			int cnt=dao.memberInsert(vo);
			if(cnt>0) {
				//성공->다시 리스트페이지로 전달(memberList.do)
				response.sendRedirect("/m42/memberList.do");			
			}else {
				throw new ServletException("error");
			}		
		}else if(command.equals("/memberDelete.do")) {
			 //memberDelete.do?num=10
			int num=Integer.parseInt(request.getParameter("num"));
			MemberDAO dao=new MemberDAO();
			int cnt=dao.memberDelete(num);
			if(cnt>0) {
			   response.sendRedirect("/m42/memberList.do");	
			}else {
			   throw new ServletException("error");	
			}		
		}else if(command.equals("/memberUpdate.do")) {
			request.setCharacterEncoding("utf-8");
			// 파라메터수집(VO)
			int num=Integer.parseInt(request.getParameter("num"));
			int age=Integer.parseInt(request.getParameter("age"));
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			
			MemberVO vo=new MemberVO();
			vo.setNum(num);
			vo.setAge(age);
			vo.setPhone(phone);
			vo.setEmail(email);
			
			MemberDAO dao=new MemberDAO();
			int cnt=dao.memberUpdate(vo);
			if(cnt>0) {
				response.sendRedirect("/m42/memberList.do");
			}else {
				throw new ServletException("error");
			}			
		}else if(command.equals("/memberContent.do")) {
			int num=Integer.parseInt(request.getParameter("num"));
			MemberDAO dao=new MemberDAO();
			MemberVO vo=dao.memberContent(num);
			// forward, 객체바인딩
			request.setAttribute("vo", vo);
			RequestDispatcher rd=request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response);		
		}
		
		
	}

}
