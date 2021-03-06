package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		//전처리부분
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		logger.debug("LoggingFilter doFilter 전철아~ : {}", uri);
		
		chain.doFilter(request, response);
		
		//후처리부분
		logger.debug("LoggingFilter doFilter 후철아~ : {}", uri);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
