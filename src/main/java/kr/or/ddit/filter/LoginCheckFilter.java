package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginCheckFilter
 * 접속 여부를 확인하여 (세션에 USER_INFO 속성이 존재 하는지)
 * 접속이 되어있지 않으면 login화면으로 이동하고 접속 되어있으면 정상적으로 최초 요청한 리소스로 위임
 * 
 * ex) /user/userList > login
 * ex) /user/userPagingList > login
 * ex) /login > /login
 * 
 */
@WebFilter("/loginFilter")
public class LoginCheckFilter implements Filter {

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		
		//jsp/userPagingList를 /userPagingList로 변경하는 작업
		uri = uri.substring(req.getContextPath().length());
		//세션이 없어도 처리가 되어야 하는 것들  /login, file.js, file.css, images file > /js, /css, /img, /login
		
		//|| uri.startsWith("/bootstrap")
		if(uri.startsWith("/login") || uri.startsWith("/js") || uri.startsWith("/css") || uri.startsWith("/img")) {
			chain.doFilter(request, response);
		//세션을 체크 해야하는 대상들
		} else if(req.getSession().getAttribute("USER_INFO") != null){
			chain.doFilter(request, response);
		} else {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect(req.getContextPath() + "/login");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
