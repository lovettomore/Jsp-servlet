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
		out.write("<table>");
		for(int i=2; i<10; i++){
			out.write("<tr>");
			for(int j=2; j<10; j++){
				out.write("<td>"+ i + "*" + j + "=" + i*j + "</td>");
			}
			out.write("</tr>");
		}
		out.write("</table>");
	%>

</body>
</html>