<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5">
		<h3 class="card-header">DB연동</h3>
		<pre class="alert alert-warning my-5" style="text-align:left">
		1. 드라이버 연동 Class.forName
		2. db연동 DriverManager.getConnection
		</pre>
		<%@page import="java.sql.*"%>
		<%
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
			if (conn != null) {out.println("db연동성공!");}
		}catch (Exception e) {e.printStackTrace();
		} finally {
			if (conn != null) {conn.close();}
		}
		%>
	</div>
</body>
</html>