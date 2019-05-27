<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
   <div class="container-fluid">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
            aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span> <span
               class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="<%=request.getContextPath()%>/main.jsp">JSP/SPRING
         <%
         	UserVO SESSION_USER = (UserVO)session.getAttribute("USER_INFO");
         	
         	String userName = "";
         	
         	if(SESSION_USER == null){
         		userName = "접속전";
         	}else{
         		userName = SESSION_USER.getName() + " 접속중";
         	}
         %>
         <%=userName %>
         </a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
         </ul>
         <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
         </form>
      </div>
   </div>
</nav>