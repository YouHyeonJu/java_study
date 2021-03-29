package kr.gsm.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.util.MyUtil;
@WebServlet("/hs.do")
public class HelloServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		
		MyUtil my =new MyUtil();
		int sum=my.hap();
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
	}

}
