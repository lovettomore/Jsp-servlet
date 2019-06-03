package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
 * Servlet implementation class ProfileController
 */
@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	private IUserService userService;
	
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("file : {}", request.getParameter("userId"));
		
		//사용자 아이디를 파라미터로부터 확인
		String userId = request.getParameter("userId");
		
		//사용자 정보(PATH)를 조회
		UserVO userVO = userService.getUser(userId);
		
		
		//PATH정보로 file을 읽어 들여서
		ServletOutputStream sos = response.getOutputStream();
		if(userVO.getPath() == null) {
			request.setAttribute("msg", "등록된 파일이 없습니다.");
		}else {
			File file = new File(userVO.getPath());
			FileInputStream fis = new FileInputStream(file);
			
			byte[] buffer = new byte[512];
			
			//response객체에 스트림으로 써준다.
			while(fis.read(buffer, 0, 512) != -1) {
				sos.write(buffer);
			};
			
			fis.close();
			sos.close();
		}
		
	}

}
