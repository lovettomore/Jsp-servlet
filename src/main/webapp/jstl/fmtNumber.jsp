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

	<%-- pageContext.setAttribute("num, 1000000") 얘랑 똑같은 말이죵 --%>
	<h2>format number (number > string) 1000000 > 1,000,000 </h2>
	<c:set value="1000000.55" var="num"/>
	
	<fmt:setLocale value="ko_kr"/>
	num - ${num} <br>
	
	<fmt:setLocale value="ko_kr"/>
	ko : <fmt:formatNumber value="${num}" type="currency"/><br>
	ko : <fmt:formatNumber value="${num}" type="percent"/><br>
	
	<fmt:setLocale value="de_DE"/>
	de : <fmt:formatNumber value="${num}" type="currency"/><br>
	de : <fmt:formatNumber value="${num}" type="percent"/><br>
	
	
	<h2>format number (string > number) / 1,000,000 >  1000000 </h2>
	<c:set value="1,000,000" var="numStr"/>
	numStr : ${numStr} <br>
	
	<fmt:setLocale value="ko_kr"/>
<%-- 	perseNumber numStr : <fmt:formatNumber value="${numStr}" pattern="0,000"/> --%>
</body>
</html>