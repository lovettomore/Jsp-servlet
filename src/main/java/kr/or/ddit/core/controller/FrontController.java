package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.core.controller.RequestMapping;


/*
	localhost/userList.do > 모가 호출이 되죵? 읅 끙매려 죽겠네 또굥이의 심정 너무 끙매려우다 
	> 이닛메서드 호출되면 서비스 메서드 호출하고여 그 메서드 안에서 do~어쩌구 저쩌구 메서드를 호출하게 되이쪄
	이렇게 해놓기로 정한거에요
	서블릿을 호출할때 서비스를 호출하는거에여 getmethod로 문자열을 가져와서 get인지 post인지 비교해서 get이면 doget post이면 dopost를호출하는거에여 아시겠어여?
	
*/
@WebServlet("*.do") //얘 
public class FrontController extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("service : {}", req.getRequestURI());
		
		String uri = req.getRequestURI();
		
		Controller controller = RequestMapping.getController(uri);
		String viewName = controller.execute(req, resp);
		
		//viewName redirect:로 시작할 경우 redirect
		//그 외에는 forward
		
		//redirect:/main.jsp
		
		ViewResolver.viewResolve(viewName, req, resp);
		
	}
	
}
