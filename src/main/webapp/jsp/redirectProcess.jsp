<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//sendRedirect 메소드 인자 값을 웹 브라우저가 수신한 후에
		//주소줄에 그대로 붙여 넣음  get방식으로 해야함, 주소에붙여 넣을 거니까
		//request.getContextPath() + "/jsp/redirectTarget.jsp" > /jsp/jsp/redirectTarget.jsp
		System.out.println(request.getParameter("userId") + " :::::: redirectProcess 최초 요청을 받은 서버");
		response.sendRedirect(request.getContextPath() + "/jsp/redirectTarget.jsp?userId=brown");
		
	%>
</body>
</html>