package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/userModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
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
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		
		String pass = request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
				
		SimpleDateFormat spDate = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = null;
		
		try {
			userVO = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, spDate.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Part profile = request.getPart("profile");
		
		//실제 파일명
		String contentDisposition = profile.getHeader("content-disposition");
		String filename = PartUtil.getFileName(contentDisposition);
		String ext = PartUtil.getExt(filename);
		
		//만약 폴더가 정상적으로 생성이 되었으면
		String uploadPath = PartUtil.getUploadPath();
		
		if(profile.getSize() > 0) {
			File uploadFolder = new File(uploadPath);
			if(uploadFolder.exists()) {
				//파일 디스크에 쓰기
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				
				userVO.setPath(filePath);
				userVO.setFilename(filename);
				
				profile.write(filePath);
				profile.delete();
			}
			
		} 
		
		int updateCnt = userService.updateUser(userVO);
		
		if(updateCnt == 1) {
			request.setAttribute("msg", "수정이 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/user?userId="+userId);
		}
	}

}
