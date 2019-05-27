package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.IntToDoubleFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserPagingController
 */
@WebServlet("/userPagingList")
public class UserPagingController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(UserPagingController.class);
	
	private static final long serialVersionUID = 1L;
	
	private IUserService userService;
	
	
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter page {}", request.getParameter("page"));
		logger.debug("parameter pageSize {}", request.getParameter("pageSize"));
		
		int page = 0;
		int pageSize = 0;
		
		if(request.getParameter("page") == null && request.getParameter("pageSize") == null) {	
			page = 1;
			pageSize = 10;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		
//		String pageString = request.getParameter("page");
//		String pageSizeString = request.getParameter("pageSize");
//		
//		int page = pageString == null ? 1 : Integer.parseInt(pageString);
//		int pageSize = pageSizeString == null ? 10 :Integer.parseInt(pageSizeString);
		
		PageVO pageVO = new PageVO(page, pageSize); //새로운 pageVO객체를 만든다. (파라미터값 페이지번호와, 페이지사이즈를 같이 넘김)
		List<UserVO> userList= userService.userPagingList(pageVO); //service에서 select문을 받아와서 pageVO를 넘김
		
		request.setAttribute("userList", userList); //request에 userList를 셋팅
		
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
