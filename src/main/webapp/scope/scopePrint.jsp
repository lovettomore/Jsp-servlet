<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${cp}/css/default.css" rel="stylesheet" type="text/css" >
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
							<td>page</td>
							<td><%=pageContext.getAttribute("pageAttribute")%></td>
							<td>jsp페이지 내에서만 공유되는 영역</td>
						</tr>
						<tr>
							<td>request</td>
							<td><%=request.getAttribute("requestAttribute")%></td>
							<td>클라이언트의 요청청보가 유지되는 동안 공유되는 영역 (dispatch)</td>
						</tr>
						<tr>
							<td>session</td>
							<td><%=session.getAttribute("sessionAttribute")%></td>
							<td>클라이언트의 정보가 유지되는 동안 공유되는 영역</td>
						</tr>
						<tr>
							<td>application</td>
							<td><%=application.getAttribute("applicationAttribute")%></td>
							<td>웹 어플리케이션 내에서 공유되는 객체의 영역</td>
						</tr>
					</table>
				</div>
			</section>
		</div>
	</div>
</body>
</html>