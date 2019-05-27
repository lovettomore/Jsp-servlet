package kr.or.ddit.sumCalculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
/**
 * 
* sumCalculation.java
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
@WebServlet("/sumCalculation")//jsp 파일에서 form action path를 써줄것!
public class SumCalculation extends HttpServlet {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter startParam : {}", request.getParameter("startParam"));
		logger.debug("parameter endParam : {} ", request.getParameter("endParam"));
		
		int start = Integer.parseInt(request.getParameter("startParam"));
		int end = Integer.parseInt(request.getParameter("endParam"));
		
		int result = 0;
		
		for(int i=start; i<=end; i++){
			result += i;
		}
		
		logger.debug("result {}", result);
		
		//HttpSession session = request.getSession();
		request.getSession().setAttribute("sumResult", result);
		
		RequestDispatcher rd =  request.getRequestDispatcher("/scope/sumResult.jsp");
        rd.forward(request, response);
		
	}

}
