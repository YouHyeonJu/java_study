package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.util.MyUtil;
@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			                            throws ServletException, IOException {
		//
		//1. 클라이언트의 요청을 받는 작업(파라메터 수집)
		int su1=Integer.parseInt(request.getParameter("su1"));
		int su2=Integer.parseInt(request.getParameter("su2"));
		// su1~su2 = ? 2.Model과 연동하는 작업
		MyUtil my=new MyUtil();
		int sum=my.hap(su1, su2);
		// 3. 요청한 클라이언트로 응답하는 작업
        response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>TOTAL</td>");
		out.println("<td>"+sum+"</td>");	
		out.println("</tr");
		out.println("</table>");
		out.println("</body>");		
		out.println("</html>");
	}
}
