<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/signIn.css">
		<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	</head>
	<body>
	
		<%--
				어디로 요청을 보낼지 form태그의 action속성을 이용한다.
				어떻게 보낼지 http method ?? form태그 method 속성 (get-default/post)
				/login/login.jsp > /login/loginProcess.jsp 
		--%>

		<div class="container">
			<form action="<%=request.getContextPath()%>/login" method="post" class="form-signin">
				<h2 class="form-signin-heading">Please sign in</h2>
				
				<label for="inputEmail" class="sr-only">Email address</label>
				<input type="userId" id="userId" class="form-control" placeholder="userId" name="userId" value="brown" required autofocus>
				
				<label for="inputPassword" class="sr-only">Password</label> 
				<input type="password" id="password" class="form-control" placeholder="password" name="password" value="brown1234" required>
				
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">Remember me </label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form>
	
		</div>
		<!-- /container -->
	</body>
</html>
