package kr.or.ddit.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	
	public static String cookieString; //분석할 쿠키 문자열

	/**
	 * 
	* Method 		: setCookieString
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param 	 	: cookieString
	* Method 설명 	: 분석할 쿠키 문자열을 받는다
	 */
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString; 
		
		
	}

	public static String getCookie(String cookie) {
		
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		String cookieValue = "";
		
		for(String str : cookieArray) {
//			logger.debug("str : {}", str);
//			logger.debug("cookie : {}",cookie); // 얘는 아이디
			
			//userId = brown
			//userI == "", "brown"
			if(str.startsWith(cookie+"=")) {
				String[] cookieStr = str.split("=");
				logger.debug("cookieStr : {}", cookieStr[1]);
				cookieValue = cookieStr[1];
				break;
			}
		}
		
		return cookieValue;
	}
	
	/**
	 * 
	* Method 		: getCookie
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param 		: cookie
	* @return
	* Method 설명 	: 쿠키 문자열에서 특정 쿠키 값을 가져온다
	 */


//	public static String getCookie(String cookie) {
//		
//		String val = cookieString;
//		String[] array = val.split("; ");
//		String result = null;
//		String name = null;
//		String key = null;
//		
//		for(int i=0; i<array.length; i++) {
//			result = array[i].substring(0, array[i].indexOf('='));
//			key = array[i].substring(array[i].indexOf('=')+1);
//		
//			name = result.trim();
//			
//			Map<String, String> resultMap = new HashMap<String, String>();
//			resultMap.put(name, key);
//			resultMap.get(cookie);
//		}
//	
//		
//		return name;
//	}
	
	

}
