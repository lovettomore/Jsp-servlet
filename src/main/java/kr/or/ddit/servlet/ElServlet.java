package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElServlet
 */

@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 	3가지 scope 객체에 같은 이름의 속성명으로 다른 값을 설정 후
		 	각 영역의 속성을 출력하기 위해 출력을 담당하는 el.jsp로 forward
		 	
		 	출력은 request > session > application 순으로 됨
		 	
		*/
		request.setAttribute("userId", "brown - request");
		request.getSession().setAttribute("userId", "cony - session");
		getServletContext().setAttribute("userId", "sally - application");
		
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
	}
	


}
