<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.Integer" required="false"%>


<c:forEach begin="1" end="${size != null ? size : 5}"><font color="${color}">-</font></c:forEach>


