<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.timesTables {width:1000px; margin:50px auto 0}
.timesTables caption {font-size:50px; margin-bottom:30px}
.timesTables td {border:1px solid #e1e1e1; padding:10px 0; color:#666; font-size:19px; text-align:center}
</style>
</head>
<body>

	<%-- localhost/jsp/jsp/timesTables.jsp --%>
	
	<table class="timesTables">
		<caption>구구단</caption>
		
		<%-- parameter를 받아 구구단 만들기 --%>
		<% 
			String prm1 = request.getParameter("i");
			String prm2 = request.getParameter("j");
			
			int num1 = Integer.parseInt(prm1);
			int num2 = Integer.parseInt(prm2);
			
			for(int i=2; i<num1; i++){ 
		%>
			<tr>
			<% for(int j=1; j<num2; j++){ %>
				<td><%= i%> * <%= j%> = <%= i*j%></td>
			<%}%>
			</tr>
		<%}%>
		
	</table>
</body>
</html>
