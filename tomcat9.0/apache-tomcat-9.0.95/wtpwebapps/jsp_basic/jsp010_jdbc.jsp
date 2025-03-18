<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5">
		<h3 class ="card-header">JDBC</h3>
		<pre>  
      	1. [src]-[main]-[webapp]-[WEB-INF]-[lib]-connectorJ.jar
      	</pre>
		<%
		try {
			//1)드라이버로딩 com.회사명.프로젝트명.jdbc.Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
			//2) jdbc 연동
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
			if(conn!=null) { out.println("db연동성공!");}
			conn.close();
			} catch (Exception e) {  e.printStackTrace(); }
		%>
	</div>
</body>
</html>