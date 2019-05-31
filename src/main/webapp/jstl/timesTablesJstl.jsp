<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table td {border:1px solid #e1e1e1; padding:10px 20px}
</style>

</head>
<body>
	
	<table>
		<c:forEach begin="1" end="${param.num1 == null ? 9 : param.num1}" var="i">
		<tr>
			<c:forEach begin="2" end="${param.num2 == null ?  9 : param.num2}"  var="j">
			<td>${i} * ${j} = ${i*j}</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
</body>
</html>