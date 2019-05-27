<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.catalina.util.ParameterMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProcess</title>
</head>
<body>
	loginProcess.jsp
	<h2>request객체의 getParameter, getPrameterValues</h2>
	
	<%-- post방식 한글 파라미터 --%>
	<% request.setCharacterEncoding("utf-8"); %>
	request.getParameter("userId") : <%=request.getParameter("userId")%><br>
	
	request.getParameterValues("userId") : <%=request.getParameter("userId") %>
	<% 
		String[] userIds = request.getParameterValues("userId");
		for(String userId : userIds){
	%>
		<%= userId%>
	<%}%>
	
	<%=request.getParameterValues("userId")%><br>
	
	request.getParameter("password") : <%=request.getParameter("password")%><br>
	
	<h2>request객체의 getParameterMap()</h2>
	<% 
		Map<String, String[]> prameterMap = request.getParameterMap(); 
		String[] userIdsFromMap = prameterMap.get("userId");
		String[] passwords = prameterMap.get("password");
		for(String userId : userIdsFromMap){
	%>
		userIdsFromMap : <%=userId%><br>
	<%}%>	
	<% for(String password : passwords){%>
		passwordsFromMap : <%=password%><br>
	<%}%>
	
	request.getParameterMap() : <%=request.getParameterMap()%><br>
	
	<h2>request객체의 getParameterNames()</h2>
	<% 
		Enumeration<String> parameterNames = request.getParameterNames(); 
		while(parameterNames.hasMoreElements()){
	%>
		parameterNames : <%= parameterNames.nextElement() %><br>
	<%	
		}
	%>
	
	
	
</body>
</html>