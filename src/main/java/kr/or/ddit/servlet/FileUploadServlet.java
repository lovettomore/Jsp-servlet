package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
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

import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 1024*1024*3, maxRequestSize = 1024*1024)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//userId, profile 파라미터를 확인
		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");
		
		logger.debug("userId : {}", userId);
		logger.debug("profile : {}", profile);

		Part part = request.getPart("profile");
		logger.debug("part.getSize() : {}", part.getSize());
		
		Collection<String> headerNames = part.getHeaderNames();
		for(String header : headerNames) {
			logger.debug("{} : {}", header, part.getHeader(header));
		}

		//파일이 존재할 때만 파일을 정해진 위치에 기록한다.
		if(part.getSize() > 0) {
			logger.debug("part.getContentType : {}", part.getContentType()); //얘는 파일 종류, 확장자
			logger.debug("part.getName : {}", part.getName()); //얘는 파라미터 명을 찍어줬어요
			
			
			String contentDispostion = part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDispostion);
			String ext = PartUtil.geExt(fileName);
			ext = ext.equals("") ? "" : "." + ext;
			
			//년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지
			Date date = new Date();
			SimpleDateFormat yyyyMMSdf = new SimpleDateFormat("yyyyMM");
			
			//String type으로 형변환
			String yyyyMM = yyyyMMSdf.format(date);
			String yyyy = yyyyMM.substring(0,4);
			String mm = yyyyMM.substring(4,6);
			
//			String yyyy = yyyySdf.format(date);
//			String mm = mmSdf.format(date);
			
			File yyyyFolder = new File("/Users/chewoop/Documents/upload/" + yyyy);
			//신규년도로 넘어갔을 때 해당 년도의 폴더를 생성한다.
			if(!yyyyFolder.exists()) {
				//해당 폴더 안에 새로운 폴더 생성
				yyyyFolder.mkdir();
			}
			
			//월에 해당하는 폴더가 있는지 확인
			File mmFolder = new File("/Users/chewoop/Documents/upload/2019/" + mm);
			if(!mmFolder.exists()) {
				mmFolder.mkdir();
			}
			
			//만약 폴더가 정상적으로 생성이 되었으면
			String uploadPath = "/Users/chewoop/Documents/upload/" + yyyy + File.separator + mm;
			File uploadFolder = new File(uploadPath);
			if(uploadFolder.exists()) {
				//파일 디스크에 쓰기
				part.write(uploadPath + File.separator + UUID.randomUUID().toString() + ext);
				part.delete();
			}
			
		}
		
		
	}

}
