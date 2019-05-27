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
		System.out.println("reuestDispatchProcess :::::: " + request.getParameter("userId"));
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/requestDispatchTarget.jsp");
		
		//위임하는 녀석에게 전달해 주겠다
		rd.forward(request, response);
	%>
</body>
</html>