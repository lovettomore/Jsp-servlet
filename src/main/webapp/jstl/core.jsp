<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>c:set</h2>
	
	<%/* 
			var 		: 속성명
			value		: 대입값
			scope 		: page(default), request, session, application
			target		: 대상 속
			property	: 대상 속성에 들어있는 필드를 이야기 하는거에요.
			
			userId라는 녀석에 brown이라는 값을 넣는것
			
			다른속성에 있는 값도 표현이 가능 해요.
			
			set태그에는 target, property도 있어요.
			
			********** 로그인 후 테스트 하세요 **********
	*/%>
	
	<%/*
		UserVO USER_INFO = (UserVO)session.getAttribute("userId");
		pageContext.setAttribute("userId", USER_INFO.getAlias());
	
	*/%>
	
	<c:set var="userId" value="${USER_INFO.alias}" scope="request"/>
	userId : ${userId} <br>
	requestScope.userId : ${requestScope.userId}<br>
	
	<!-- 
		에러가 나는 이유 : target에 user_info가 값이 null인데 없는 값에 alias의 값으로 bear를 주니까 에러남.
		세션이 없는 상태에서 하면 로그인이 정상적으로 되었을 떄 사용자 정보를 여기에 넣는데 alias 다른 값을 대입하는 구문이에요. 
	-->
	<%-- <c:set target="${USER_INFO}" property="alias" value="bear"/> --%>
	USER_INFO.alias : ${USER_INFO.alias}<br>
	
	<h2>c:if *** c:if는 java의 if-else if -else중에서 if에만 해당 (c:choose 태그가 일반적인 문)</h2>
	
	<!-- if(test) -->
	<c:if test="${USER_INFO.userId == 'brown'}">
		userId는 brown입니다.
	</c:if>
	
	<c:if test="${USER_INFO.userId == 'sally'}">
		userId는 sally입니다.
	</c:if>
	
	<!-- 
		code가 도대체 뭐길래!!
	-->
	
	<%
		request.setAttribute("code", "03");
	%>
	<h2>c:choose 자바의 if - else if- else</h2>
	<c:choose>
		<c:when test="${code == '01'}">
			code is 01
		</c:when>
		<c:when test="${code == '02'}">
			code is 02
		</c:when>
		<c:when test="${code == '03'}">
			code is 03
		</c:when>
		<c:when test="${code eq '04'}">
			code is 04
		</c:when>
		<c:otherwise>
			code is ${code};
		</c:otherwise>
	</c:choose>
	
	<h2>el 연산</h2>
	<%
		PageVO pageVO = new PageVO(1, 10);
		request.setAttribute("pageVO", pageVO);
	%>
	
	page + 2 : ${pageVO.page + 2}
	
	<h2>c:forEach 일반 반복문</h2>
	<!-- for(int i=1; i<10; i++) -->
	<c:forEach begin="1" end="10" step="1" var="i">
		${i}<br>
	</c:forEach>
	
	
	<h2>foreach map</h2>
	<%
		
		Map<String, String> dataMap = new HashMap<String, String>();
		//name, age, hp
		
		dataMap.put("name", "brown");
		dataMap.put("age", "3");
		dataMap.put("hp", "010-1818-1818");
		
		for(String key :dataMap.keySet()){
			out.write(dataMap.get(key) + "<br>");
		}
		
		//어딘가에 넣어줘야해요
		request.setAttribute("dataMap", dataMap);
	%>
	
	--------------------------------------------------------------------
	
	<c:forEach items="${dataMap}" var="data">
		<p>${data.key} / ${data.value}</p>
	</c:forEach>
	
	
</body>
</html>