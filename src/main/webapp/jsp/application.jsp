<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedReader"%>
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
		out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
		out.write("application.getserverInfo() : " + application.getServerInfo() + "<br>");
		out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
		out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
		out.write("application.getInitParameter(\"ADMIN\") : " + application.getInitParameter("ADMIN")  + "<br>");
		
		out.write("application.getRealPath(\"/res/190522.txt\") : " +  application.getRealPath("/res/190522.txt") + "<br><br>");
		
		BufferedReader bReader = null;
		
		try{
			String line;
			File file = new File(application.getRealPath("/res/190522.txt"));
			bReader = new BufferedReader(new FileReader(file));
			
			while((line = bReader.readLine()) != null){
				out.write(line +"<br>");
			}
		}catch(IOException e) {
	         e.printStackTrace();
		} finally {
			try {
	             if(bReader != null) bReader.close();
			} catch(IOException e) {
	             e.printStackTrace();
			}
		}

	%>

</body>
</html>