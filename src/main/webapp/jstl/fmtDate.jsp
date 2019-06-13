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

	<h2>format date</h2>
	<c:set var="dt" value="<%= new Date()%>"/>
	date : ${dt}<br>
	date : <fmt:formatDate value="${dt}" pattern="yyyy-MM-dd"/><br>
	date : <fmt:formatDate value="${dt}" pattern="yyyy/MM/dd"/><br>
	date : <fmt:formatDate value="${dt}" type="time"/><br>
	date FULL : <fmt:formatDate value="${dt}" type="date" dateStyle="FULL"/><br>
	date MEDIUM : <fmt:formatDate value="${dt}" type="date" dateStyle="MEDIUM"/><br>
	date SHORT : <fmt:formatDate value="${dt}" type="date" dateStyle="SHORT"/><br>
	date : <fmt:formatDate value="${dt}" type="both"/><br>
	
	<h3>de</h3>
	<fmt:setLocale value="de_DE"/>
	dt : <fmt:formatDate value="${dt}"/><br>
	
	<h2>parse date (String > date / 2019.6.13 > date)</h2>
	<fmt:setLocale value="ko_KR"/>
	<c:set var="dtStr" value="2019.6.13"/>
	parse date String : ${dtStr}<br>
	parse date String : <fmt:parseDate value="${dtStr}" pattern = "yyyy.MM.dd"/>
	
	
</body>
</html>