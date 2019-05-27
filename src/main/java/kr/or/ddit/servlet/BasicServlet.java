package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{
	
	//doGet이라는 메서드 오버라이드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//이 서블릿에서 만들어주는게 해석해야하는 방향을 결정해 줘요.
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("<!doctype html>");
		pw.write("	<head>");
		pw.write("		<title>hello, world!</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<span>hello, world!</span>");
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();
		
		//서블릿이 실행되는 조건에 대해서 기술을 하는데
	}

	//init()는 딱 한번 호출 된다.
	@Override
	public void init() throws ServletException {
		System.out.println("BasicServlet init()");
	}
}
