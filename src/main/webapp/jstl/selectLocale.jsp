<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#lang").val("${nation}");
		$("#lang").on("change", function(){
			var lang = $(this).val();
			//location.href = "${cp}/selectLocale?languege="+lang;
			$("#frm").submit();
		});
	});
</script>
</head>
<body>

<%-- 로케일을 한국어로 설정 --%>

<h2> select locale </h2>
<form id="frm" method="post" action="${cp}/selectLocale">
	<select id="lang" name="lang">
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="jp">日本語</option>
	</select>
	<br><br><br>
	<fmt:setLocale value="${nation}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR"> <%-- 얘는 파라미터를 줄수 있어요 --%>
			<fmt:param value="brown"/>
		</fmt:message>
	</fmt:bundle>
</form>

</body>
</html>