package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimesTablesServlet extends HttpServlet{
	
	//kr.or.ddit.servlet.TimesTablesServlet
	private Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		//localhost/jsp/timesTables?param=6 param이 parameter의 이름이 됩니다.
		String param1 = req.getParameter("param1"); //String
		logger.debug("param : {}", param1);
		String param2 = req.getParameter("param2"); //String
		logger.debug("param : {}", param2);
		
		int num1 = Integer.parseInt(param1);
		int num2 = Integer.parseInt(param2);
		
		pw.write("<!doctype html>");
		pw.write("	<head>");
		pw.write("		<title>GUGUDAN</title>");
		pw.write("	<style>");
		pw.write("		table td{border:1px solid #e1e1e1; padding:8px 5px; color:#666}");
		pw.write("	</style>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<div>");
	pw.write("				<table>");
		for(int dan=1; dan<num2+1; dan++) {
			pw.write("			<tr>");
			for(int gop=2; gop<num1+1; gop++) {
				pw.write("				<td>");
				pw.write(gop + " * " + dan + " = " + dan*gop);
				pw.write("				</td>");
			}
			pw.write("			</tr>");
		}
		pw.write("			</table>");
		pw.write("		</div>");
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();
	}
	
}
