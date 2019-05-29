<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- scope객체에 저장한 속성명  -->
	userId	: ${userId}<br>
	
	<!-- 특정 scope객체에 있는 속성을 명시적으로 가져올 경우 -->
	requestScope.userId 	: ${requestScope.userId}<br>
	sessionScope.userId 	: ${sessionScope.userId}<br>
	applicationScope.userId : ${applicationScope.userId}<br>
	
	<!-- session 삭제 -->
	<% //session.removeAttribute("userId"); %>
	
	<!-- el로 parameter 접근 - param.parameterName -->
	param.userId : ${param.userId}
</body>
</html>