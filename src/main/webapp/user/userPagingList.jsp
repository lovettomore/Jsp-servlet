<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								<%
									List<UserVO> userList = (List<UserVO>)request.getAttribute("userList");
									for(UserVO user : userList){
								%>
								<tr>
									<td><%=user.getUserId() %></td>
									<td><%=user.getName() %></td>
									<td><%=user.getAlias() %></td>
									<td></td>
								</tr>
								<%} %>
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
									if(pageVO.getPage() == 1){
								%>
									<li class="disabled"><span>«</span></li>
								<% }else{ %>
									<li>
										<a href="<%=request.getContextPath()%>/userPagingList?page=<%=pageVO.getPage()-1%>&pageSize=<%=pageVO.getPageSize()%>">«</a>
									</li>
								<% 
									} 
									
									int paginationSize = (Integer)request.getAttribute("paginationSize");
									for(int i=1; i<paginationSize+1; i++){
								%>
								
								<!-- 
									내가 현재 어떤 페이지에 있는지 어떻게 알 수 있지?
									pageVO에 있어요. page와 pageSize를 이용해서 pageVO를 만들어용.
								-->

								<li 
									<% if(i == pageVO.getPage()){ %> 
									class="active"
									<% } %>
								>
									
									<% if(i == pageVO.getPage()){ %>
										<span><%=i%></span>
									<% }else{ %>
										<a href="<%=request.getContextPath()%>/userPagingList?page=<%=i%>&pageSize=<%=pageVO.getPageSize()%>"><%=i%></a>
									<% } %>
									
								</li>
								<% 
									}
									if(pageVO.getPage() >= paginationSize){
								%>
									<li class="disabled"><span>»</span></li>
								<% }else{ %>
									<li>
										<a href="<%=request.getContextPath()%>/userPagingList?page=<%=pageVO.getPage()+1%>&pageSize=<%=pageVO.getPageSize()%>">»</a>
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