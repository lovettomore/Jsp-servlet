<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- application 속성 sessionMap정보를 화면에 표현 --%>
<table>
	<tr>
		<th>session id</th>
		<th>USER_INFO.name</th>
	</tr>
	<tr>
		<c:forEach items="${sessionMap}" var="sess">
		<td>${sess.key}</td>
		<td>${sess.value.getAttribute("USER_INFO").name}</td>
		</c:forEach>
	</tr>
</table>

<h2>sessionUserMap</h2>
<table>
	<tr>
		<th>사용자 아이디</th>
		<th>사용자 이름</th>
	</tr>
	<c:forEach items="${sessionUserMap}" var="ssUser">
	<tr>
		<td>${ssUser.key}</td>
		<td>${ssUser.value.name}</td>
	</tr>
	</c:forEach>
</table>
