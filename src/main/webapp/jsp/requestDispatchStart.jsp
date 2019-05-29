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
				<span>jsp</span>
				<h2>Request Dispatch</h2>
				<p>client [최초로 요청을 보내는 페이지]</p>
			</section>
			<section id="contents">
					<p class="ex">
						
					</p>
					<form action="${pageContext.request.contextPath}/jsp/requestDispatchProcess.jsp">
						<p><input type="text" name="userId" id="userId" value="sally"></p>
						<p><input type="submit" value="requestDispatch"></p>
					</form>
			</section>
		</div>
	</div>
</body>
</html>