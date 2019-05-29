<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<form action="${pageContext.request.contextPath}/scope/scopeReceive.jsp" method="post">
						page <input type="text" name="pageParam" value="pageValue"><br>
						request <input type="text" name="requestParam" value="requestValue"><br>
						session <input type="text" name="sessionParam" value="sessionValue"><br>
						application <input type="text" name="applicationParam" value="applicationValue"><br>
						<button>전송하기</button>
					</form>
				</div>
			</section>
		</div>
	</div>
</body>
</html>