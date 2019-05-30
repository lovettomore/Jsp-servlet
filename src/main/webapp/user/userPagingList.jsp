<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>사용자 페이징 리스트</title>
	<%@include file="/common/basicLib.jsp"%>
</head>

<body>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/common/sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>번호</th>
									<th>사용자 아이디(el)</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								
								<c:forEach items="${userList}" var="user" varStatus="status">
									<tr>
										<td>${status.index} / ${status.count}</td>
										<td>${user.userId}</td>
										<td>${user.name}</td>
										<td>${user.alias}</td>
										<td></td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						
						
						<!-- 
								사용자 수 		: 105건 
								페이지네이션 	: 11페이지
						-->
						<div class="text-center">
							<ul class="pagination">
								<%
									PageVO pageVO = (PageVO)request.getAttribute("pageVO");
									int paginationSize = (Integer)request.getAttribute("paginationSize");
								%>
								
								<c:choose>
									<c:when test="${pageVO.page == 1}">
										<li class="disabled"><span>«</span></li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${pageContext.request.contextPath}/userPagingList?page=${pageVO.page-1}&pageSize=${pageVO.pageSize}">«</a>
										</li>
									</c:otherwise>
								</c:choose>
								
								<!-- 
									내가 현재 어떤 페이지에 있는지 어떻게 알 수 있지?
									pageVO에 있어요. page와 pageSize를 이용해서 pageVO를 만들어용.
								-->
								<c:forEach begin="1" end="${paginationSize+1}" step="1" var="i">
									<c:choose>
										<c:when test="${pageVO.page == i}">
											<li class="active"><span>${i}</span></li>
										</c:when>
										<c:otherwise>
											<li>
												<a href="${pageContext.request.contextPath}/userPagingList?page=${i}&pageSize=${pageVO.pageSize}">${i}</a>
											</li>
										</c:otherwise>
									</c:choose>
									</li>
								</c:forEach>

								<c:choose>
									<c:when test="${pageVO.page >= paginationSize}">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${pageContext.request.contextPath}/userPagingList?page=${pageVO.page+1}&pageSize=${pageVO.pageSize}">»</a>
										</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>