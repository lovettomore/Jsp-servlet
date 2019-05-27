<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>hello, World</p>
	<%-- jsp주석 --%>
	
	<%-- <% %>[스크립틀릿] - 이 부분은 자바 코드를 작성하는 영역 입니다. --%>
	<% Date date = new Date(); %>
	
	<%-- <%= %>[표현식] - 이 부분은 객체를 출력하는 영역 입니다. --%>
	<p><span>현재시간 : </span><%=date%></p>
</body>
</html>