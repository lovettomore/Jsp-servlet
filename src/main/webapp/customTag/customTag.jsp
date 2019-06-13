<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>1. fixed text : --------------------------------------------------------------------------------------------------</p>
	<p>2. loop : <c:forEach begin="1" end="100">-</c:forEach></p>
	<p>3. customTag : <ct:logging/></p>
	<p>4. loopcustomTag : <ct:loopLogging/></p>
	<p>5. colorLogging : <ct:colorLogging color="blue"/></p>
	<p>6. colorLogging : <ct:colorLogging color="blue" size="100"/></p>
	<p>7. rangersTag : <ct:rangers rangers="brown,cony,james,sally,moon"/></p>
	<p>6. colorLogging : <ct:colorLogging color="blue" size="100"/></p>
	<p>7. myFile : <ct:code code="HC"/></p>
</body>
</html>