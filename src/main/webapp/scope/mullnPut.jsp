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
				<h2>jsp scope TEST - Multiplication Input</h2>
				<p>스코프의 종류 및 특성 [ 각 스코프별 특성 출력 ]</p>
			</section>
			<section id="contents">
				<form action="${pageContext.request.contextPath}/mulCalculation" method="post">
					<table>
						<tr>
							<th>첫번째 숫자</th>
							<th>두번째 숫자</th>
						</tr>
						<tr>
							<td><input type="text" name="param1" placeholder="시작하는 값을 일력하세요."></td>
							<td><input type="text" name="param2" placeholder="시작 값보다 작은 값을 넣으세요."></td>
						</tr>
					</table>
					<button class="btn_style_01">전송하기</button>
				</form>
			</section>
		</div>
	</div>
</body>
</html>