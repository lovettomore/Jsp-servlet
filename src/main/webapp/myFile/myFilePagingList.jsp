<%@page import="kr.or.ddit.myFile.model.MyFileVO"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
									<th>파일 아이디</th>
									<th>파일 분류</th>
									<th>파일 이름</th>
									<th>파일 서버이름</th>
									<th>파일 크기</th>
								</tr>
								<%
									List<MyFileVO> myFileList = (List<MyFileVO>)request.getAttribute("myFileList");
								%>
								<c:forEach items="${myFileList}" var="myFile">
									<tr>
										<td>${myFile.file_seq}</td>
										<td>${myFile.file_bd_code}</td>
										<td>${myFile.file_original_name}</td>
										<td>${myFile.file_server_name}</td>
										<td>${myFile.file_size}</td>
									<tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						
						<!-- 
								파일 수 		: 33건 
								페이지네이션 	: 4페이지
						-->
						<div class="text-center">
							<ul class="pagination">
								
								<%
									PageVO pageVO = (PageVO)request.getAttribute("pageVO");
									int paginationSize = (Integer)request.getAttribute("paginationSize");
									
									if(pageVO.getPage() == 1){
								%>
									<li class="disabled"><span>«</span></li>
								<% }else{ %>
									<li>
										<a href="${pageContext.request.contextPath}/myFilePagingList?page=<%=pageVO.getPage()-1%>&pageSize=<%=pageVO.getPageSize()%>">«</a>
									</li>
								<% } %>
								
								
								<%
									for(int i=1; i<paginationSize+1; i++){
								%>
									<li 
									<% if(i == pageVO.getPage()){ %> 
									class="active"
									<% } %>
									>
										<a href="${pageContext.request.contextPath}/myFilePagingList?page=<%=i%>&pageSize=<%=pageVO.getPageSize()%>"><%=i%></a>
									</li>
								<%
									}
								%>
								
								<%
									if(pageVO.getPage() >= paginationSize){
								%>
									<li class="disabled"><span>»</span></li>
								<% }else{ %>
									<li>
										<a href="${pageContext.request.contextPath}/myFilePagingList?page=<%=pageVO.getPage()+1%>&pageSize=<%=pageVO.getPageSize()%>">»</a>
									</li>
								<% } %>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>