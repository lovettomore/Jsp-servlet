<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li><a href="<%=request.getContextPath()%>/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li><a href="<%=request.getContextPath()%>/userList">사용자 리스트</a></li>
		<li><a href="<%=request.getContextPath()%>/userPagingList">사용자 페이징 리스트</a></li>
		<li><a href="<%=request.getContextPath()%>/myFilePagingList">member 페이징 리스트</a></li>
	</ul>
</div>
