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
				<span>jsp</span>
				<h2>redirect</h2>
				<p>client [최초로 요청을 보내는 페이지]</p>
			</section>
			<section id="contents">
					<p class="ex">
						1. localhost/jsp/jsp/redirectstart.jsp접속<br>
						1-1.redirect버튼 클릭 : 최초요청<br>
						2. redirectProcess.jsp가 최초 요청을 수신<br>
						2-1. response.sendRedirect("jsp/jsp/redirectTartget.jsp") : 클라이언트에게 리다이렉트 지시<br>
						3. 웹 브라우저가 리다이렉트응답을 받고, 수신한 리다이렉트주소(/jsp/jsp/redirectTarget.jsp)를 웹브라우저 주소줄에 입력하여 두번째 요청을 보낸다.
					</p>
					<form action="<%=request.getContextPath()%>/jsp/redirectProcess.jsp">
						<p><input type="text" name="userId" id="userId" value="sally"></p>
						<p><input type="submit" value="redirect"></p>
					</form>
			</section>
		</div>
	</div>
	
</body>
</html>