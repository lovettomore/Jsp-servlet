<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 로케일을 한국어로 설정 --%>
<h2>ko</h2>
<fmt:setLocale value="ko"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/><br>
	<fmt:message key="VISITOR"> <%-- 얘는 파라미터를 줄수 있어요 --%>
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

<%-- 로케일을 영어로 설정 --%>
<h2>en</h2>
<fmt:setLocale value="en"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/><br>
	<fmt:message key="VISITOR"> <%-- 얘는 파라미터를 줄수 있어요 --%>
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

<%-- 로케일을 일본어로 설정 --%>
<h2>jp</h2>
<fmt:setLocale value="jp"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/><br>
	<fmt:message key="VISITOR"> <%-- 얘는 파라미터를 줄수 있어요 --%>
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

<%-- 번들태그로 감쌌니? 안감쌌니? 차이에용 --%>
<h2>setBundle</h2>
<fmt:setBundle basename="kr.or.ddit.msg.msg" var="message"/>
<fmt:message key="GREETING" bundle="${message}"/>
<fmt:message key="VISITOR" bundle="${message}">
	<fmt:param value="brown"/>
</fmt:message>

</body>
</html>