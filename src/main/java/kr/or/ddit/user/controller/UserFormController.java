package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class UserFormController
 */
@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserFormController.class);
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	//사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		logger.debug("userForm doPost");
		logger.debug("userid parameter : {}", request.getParameter("userId")); //잘 들어오넹
		
		
		//사용자 보낸 파라미터를 사용해서 UserVO인스턴스를 만들어서
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//사용자가 입력한 userId가 이미 존재 하는 userId인지 체크
		UserVO dbUser = userService.getUser(userId);
		
		//등록된 사용자가 아닌경우
		if(dbUser == null) {
			int insertCnt = userService.insertUser(userVO);
			
			//정상적으로 등록된 경우
			if(insertCnt == 1) {
				response.sendRedirect(request.getContextPath()+"/userPagingList");
			} 
		}else {
			//redirect, forward - respons로 보내면 userForm서블릿을 다시 타기 떄문에 안대용
			//doGet메서드 호출
			request.setAttribute("msg", "이미 존재하는 사용자 입니다.");
			doGet(request, response);
		}
		
		//존재하지 않을 경우  {
		
			//userService 객체를 통해 insertUser(userVO);
			
			//정상적으로 입력이 된 경우 - 사용자 페이징 리스트 1페이지로 이동
			
			//정상적으로 입력이 되지 않은 경우 - 사용자가 입력한 값을 input에 넣어준다.
		//}
	
		//존재할 경우 {
			
			// 사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
			// 이미 존재하는 userId입니다(alert 또는 text표시)
		//}
	
	
	}

}
