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
	*/%>
	
	<%/*
		UserVO USER_INFO = (UserVO)session.getAttribute("userId");
		pageContext.setAttribute("userId", USER_INFO.getAlias());
	
	*/%>
	
	<c:set var="userId" value="${USER_INFO.alias}" scope="request"/>
	userId : ${userId} <br>
	requestScope.userId : ${requestScope.userId}<br>
	
	<c:set target="${USER_INFO}" property="alias" value="bear"/>
	USER_INFO.alias : ${USER_INFO.alias}<br>
	
	<h2>c:if *** c:if는 java의 if-else if -else중에서 if에만 해당 (c:choose 태그가 일반적인 문)</h2>
	
	<!-- if(test) -->
	<c:if test="${USER_INFO.userId == 'brown'}">
		userId는 brown입니다.
	</c:if>
	
	<c:if test="${USER_INFO.userId == 'sally'}">
		userId는 sally입니다.
	</c:if>
</body>
</html>