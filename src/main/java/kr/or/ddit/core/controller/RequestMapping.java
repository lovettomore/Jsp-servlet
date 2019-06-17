package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.model.DBVO;
import kr.or.ddit.service.DBService;
import kr.or.ddit.service.IDBService;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(RequestMapping.class);
	
	/*
		main.do로 요청이 오면 mainController에서 처리를 한다던가
		userList.do로 요청이 오면 userListController에서 처리를 한다던가
	
		private static Map<String, String> requestMappingClass;
	
		약간 좋은 방법은 아닌데 서비스 객체를 선언을 합시다 
		코드가 억지스러운 부분은 이써여 
		원래 코드를 주석처리 해도 돌아가게 해보세영
	*/
	private static Map<String, Controller> requestMapping;
	
	private static IDBService dbService = new DBService();
	
	static {
		
		List<DBVO> urlClassMappingList = dbService.dbList();
		requestMapping = new HashMap<String, Controller>();
		
		for(DBVO mappingList : urlClassMappingList) {
			
			String uri = mappingList.getUri();
			String classInfo = mappingList.getClassname();
			
			try {
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(uri, (Controller) obj);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		//얘는 데이터베이스에서 가꼬오는 값이다라고 맨날 얘기했는데 한번 만드러 보까욤
//		requestMappingClass = new HashMap<String, String>();
//		requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		
		
		
//		for (String key : requestMappingClass.keySet()) {
//			//classInfo에는 kr.or.ddit.controller.MainController 이런 정보가 담겨 있는거죵?
//			String classInfo = requestMappingClass.get(key);
//			try {
//				Class clazz = Class.forName(classInfo);
//				Object obj = clazz.newInstance();
//				requestMapping.put(key, (Controller) obj);
//			} catch (InstantiationException | IllegalAccessException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
		
//		String clss = "Integer";
//		Integer i = new Integer(5);

		
		//requestMapping.put("/main.do", new MainController());
		//requestMapping.put("/userList.do", new userListController());
	}
	
	public static Controller getController(String uri) {
		logger.debug("getController : {}", uri);
		return requestMapping.get(uri);
	}
	
}
