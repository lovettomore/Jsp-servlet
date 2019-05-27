<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/default.css" rel="stylesheet" type="text/css" >
</head>
<body>
	<div id="wrap">
		<div class="container">
			<section id="hdTitle">
				<span>scope</span>
				<h2>jsp scope TEST - Sum Input</h2>
				<p>스코프의 종류 및 특성 [ 각 스코프별 특성 출력 ]</p>
			</section>
			<section id="contents">
				<div class="loginForm">
					<form action="<%=request.getContextPath()%>/sumCalculation" method="post">
						<table>
							<tr>
								<th>start<th>
								<td><input type="text" name="startParam" placeholder="시작하는 값을 일력하세요."></td>
							</tr>
							<tr>
								<th>end<th>
								<td><input type="text" name="endParam" placeholder="마지막 값을 입력하세요."></td>
							</tr>
						</table>
						<button>전송하기</button>
					</form>
				</div>
			</section>
		</div>
	</div>
</body>
</html>