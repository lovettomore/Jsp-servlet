package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserModifyController.class);
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger.debug("userId parameter : {}", request.getParameter("userId"));
		
		String userId = request.getParameter("userId");
		
		//사용자 아이디로 사용자 정보를 조회
		UserVO userVO = userService.getUser(userId);
		
		//조회 결과를 request객체에 속성으로 저장
		request.setAttribute("userVO", userVO);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		logger.debug("UserModifyController doPost");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		
		SimpleDateFormat spDate = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = null;
		
		try {
			userVO = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, spDate.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int updateCnt = userService.updateUser(userVO);
		
		if(updateCnt == 1) {
			request.setAttribute("msg", "수정이 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/user?userId="+userId);
		}
	}

}
