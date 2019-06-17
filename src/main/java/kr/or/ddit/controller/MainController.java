package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller{

	//얘는 httpServlet을 상속을 받지 않았어요 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//에러가 뜨네옹? throws선언을 해줘용 해주니께 throws에서 에러가 뜨죵? 그래서 controller에다가 throws를 복사해서 붙여넣어줘용
		return "/main.jsp"; //당연히 에러가 뜨겠죠
		
		
		//request.getRequestDispatcher("/main.jsp").forward(request, response);
		//아무것도 없을때는 기본으로 forward를 시키고 redirect: 되어있으면 redirect를 하는것으로 해봐요
		//return "redirect:/main.jsp" 이런식으로요
		
		
		//[PATH]정보만 리턴을 할거에요
		//request.getRequestDispatcher([PATH]).forward(request, response);
		//response.sendRedirect([PATH]);
	}

}
