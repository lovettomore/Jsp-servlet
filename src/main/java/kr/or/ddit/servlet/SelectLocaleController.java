package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class SelectLocaleController
 */
@WebServlet("/selectLocale")
public class SelectLocaleController extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(SelectLocaleController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String nation = request.getParameter("languege");
		//request.setAttribute("nation", request.getParameter("languege"));
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nation = request.getParameter("lang");
		request.setAttribute("nation", nation);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);

	}

}
