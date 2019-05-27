<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Disposition", "attachment; filename=excel.xls");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>이름</th>
			<th>영문명</th>
		</tr>
		<tr>
			<td>이미지1</td>
			<td>image1</td>
		</tr>
		<tr>
			<td>이미지2</td>
			<td>image2</td>
		</tr>
		<tr>
			<td>이미지3</td>
			<td>image3</td>
		</tr>
		<tr>
			<td>이미지4</td>
			<td>image4</td>
		</tr>
	</table>
			
</body>
</html>