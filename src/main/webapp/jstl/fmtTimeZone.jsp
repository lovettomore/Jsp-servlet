<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>time zone</h2>
	
	<c:set value="<%=new Date() %>" var="date"/>
	Korea date : <fmt:formatDate value="${date}" type="both"/><br>
	
	<fmt:setTimeZone value="Poland" var="pol"/>
	Poland date : <fmt:formatDate value="${date}" timeZone="${pol}" type="both"/><br>
	
	<fmt:timeZone value="Poland">
		Poland date : <fmt:formatDate value="${date}" type="both"/><br>
	</fmt:timeZone>
	
	<c:forEach items="<%=TimeZone.getAvailableIDs() %>" var="TimeZone">
		${TimeZone} <br>
	</c:forEach>
</body>
</html>