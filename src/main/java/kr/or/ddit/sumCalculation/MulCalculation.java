package kr.or.ddit.sumCalculation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class MulCalculation
 */
/**
 * 
* MulCalculation.java
*
* @author chewoop
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* chewoop 최초 생성
*
* </pre>
 */

@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(MulCalculation.class);
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter param1 {} ", request.getParameter("param1"));
		logger.debug("parameter param2 {} ", request.getParameter("param2"));
		
		int num1 = Integer.parseInt(request.getParameter("param1"));
		int num2 = Integer.parseInt(request.getParameter("param2"));
		
		int result = num1 * num2;
		
		if(request.getParameter("param1").equals(null) || request.getParameter("param2").equals(null)){
			
			request.getRequestDispatcher("/scope/mullnPut.jsp").forward(request, response);
		}
		
		request.getSession().setAttribute("mulResult", result);
		
		request.getRequestDispatcher("/scope/mulResult.jsp").forward(request, response);
	}

}
