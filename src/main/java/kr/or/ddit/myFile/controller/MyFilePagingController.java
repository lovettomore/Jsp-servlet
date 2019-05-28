package kr.or.ddit.myFile.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.myFile.model.MyFileVO;
import kr.or.ddit.myFile.service.IMyFileService;
import kr.or.ddit.myFile.service.MyFileService;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class LprodPagingController
 */
@WebServlet("/myFilePagingList")
public class MyFilePagingController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(MyFilePagingController.class);
	
	private static final long serialVersionUID = 1L;
	
	//서비스 객체 생성
	IMyFileService myFileService;

	public void init() throws ServletException {
		myFileService = new MyFileService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("MyFilePagingController doGet()"); //아주 잘 들어오구 있꾼뇽??
		
		logger.debug("parameter page : {}", request.getParameter("page"));
		logger.debug("parameter pageSize : {}", request.getParameter("pageSize"));
		
		
		int page = 0;
		int pageSize = 0;
		
		//page의 값과 pageSize의 값이 null이라면 디폴트값 지정 : 1 / 10
		if(request.getParameter("page") == null && request.getParameter("pageSize") == null) {
			page = 1;
			pageSize = 5;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		
		//페이지의 속성을 담은 pageVO 객체 생성
		PageVO pageVO = new PageVO(page, pageSize);
		Map<String, Object> resultMap = myFileService.myFilePasingList(pageVO);
		
		List<MyFileVO> myFileList = (List<MyFileVO>) resultMap.get("myFileList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		request.setAttribute("myFileList", myFileList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVO", pageVO);
		
		
		request.getRequestDispatcher("/myFile/myFilePagingList.jsp").forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
