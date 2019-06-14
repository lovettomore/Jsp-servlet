package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class RequestCountFilter
 */
@WebFilter("/requestCount")
public class RequestCountController implements Filter {
	
	/*
		
		/jsp/login : 10
		/jsp/userList : 20
		 특정 url별로 총 몇번이 왔는지 궁금한거잖아요? usi가 키가 되는거고 횟수는 값이 되는거죠 그래서 map이 좋을거 같아요

	*/
	private Map<String, Integer> requestMap;
	
	public void init(FilterConfig fConfig) throws ServletException {
		requestMap = new HashMap<String, Integer>();
		requestMap.put("userId", 10);
		fConfig.getServletContext().setAttribute("requestMap", requestMap);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
			요청이 올때마다 uri를 체크해서 requestMap에 데이터를 한건씩 증가시켜 줄라고 하고둔용?
			만약에 uri값이 /jsp/login이였다고 가정합시다.
		*/
		String uri = ((HttpServletRequest)request).getRequestURI();
		int reqCount = requestMap.getOrDefault(uri, 0);
		
		reqCount++; //하나를 증가를 시키고
		requestMap.put(uri, reqCount);//맵 객체에다가 반영을 시켜야겠죵?
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		
	}

}
