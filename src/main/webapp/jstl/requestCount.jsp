<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- application(getServletContext()) : requestMap --%>
	<table>
		<tr>
			<th>uri</th>
			<th>요청횟수</th>
		</tr>
		<tr>
<%-- 			<c:forEach items="${requestMap}" var="map"> --%>
<%-- 			<td>${map.uri}</td> --%>
<%-- 			<td>${map.reqCount}</td> --%>
<%-- 			</c:forEach> --%>
		</tr>
	</table>
</body>
</html>