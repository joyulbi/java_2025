<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp022_header.jsp -->    
<!-- jsp022_header.jsp -->   
<!-- jsp022_header.jsp -->   
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- navbar -->
<!-- navbar -->

<nav class="navbar navbar-expand-sm navbar-dark bg-warning">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      
      <ul class="navbar-nav d-flex">
	  <%   
	     String id= (String)session.getAttribute("username");
	  	 if( id != null){    %>
			<!-- 로그인했을때 -->
			<!-- 로그인했을때 -->
	        <li class="nav-item">
	          <a class="nav-link" href="jsp022_my.jsp"><%=id%></a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="jsp022_logout.jsp">LOGOUT</a>
	        </li>
     <%   }else{    %>
			<!-- 로그인안했을때 -->
			<!-- 로그인안했을때 -->
	        <li class="nav-item">
	          <a class="nav-link" href="jsp022_login.jsp">LOGIN</a>
	        </li>        
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">JOIN</a>
	        </li>   
	  <%  }      %>  
      </ul>     
      
    </div>
  </div>
</nav>

 