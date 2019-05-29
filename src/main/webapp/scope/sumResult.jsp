<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css" >
</head>
<body>
	<div id="wrap">
		<div class="container">
			<section id="hdTitle">
				<span>scope</span>
				<h2>jsp scope TEST</h2>
				<p>스코프의 종류 및 특성 [ 각 스코프별 특성 출력 ]</p>
			</section>
			<section id="contents">
				<div class="loginForm">
					<table>
						<tr>
							<td>result</td>
							<td><%=session.getAttribute("sumResult")%></td>
							<td>jsp페이지 내에서만 공유되는 영역</td>
						</tr>
					</table>
					<%out.write(request.getContextPath());%>
				</div>
			</section>
		</div>
	</div>
</body>
</html>