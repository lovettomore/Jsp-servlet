package kr.or.ddit.dbConnection;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class DBConnectionServlet
 */
@WebServlet(urlPatterns = "/DBConnectionServlet", loadOnStartup = 1)
public class DBConnectionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(DBConnectionServlet.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//최초 요청을 해야지만 init메서드가 한번 실행 됨
		logger.debug(" DBConnectionServlet init() ");
		
		//basicDatasource 객체를 생성 > application 객체에 속성으로 저장
		BasicDataSource bs = new BasicDataSource();
		bs.setUrl("jdbc:oracle:thin:@112.220.114.130:1521:xe");
		bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bs.setUsername("MDMS");
		bs.setPassword("java");
		bs.setInitialSize(20); //초기값 설정
		
		ServletContext application = config.getServletContext();
		application.setAttribute("bs", bs);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug(" DBConnectionServlet doGet() ");
	}
	
	

}
