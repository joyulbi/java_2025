<%@page import="java.util.Arrays"%>
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
		<h3 class="card-header">CheckBox</h3>
		<%
		//1. 넘겨주는 데이터 확인
		String username = request.getParameter("username");
		String[] options1 = request.getParameterValues("option1");
		%>
		<!--  <p><%=username%></p> -->
		<table class="table table-striped">
			<caption> checkbox 데이터 확인</caption>
			<tbody>
				<tr> <!-- 한줄 -->
					<th scope="row">USER</th> <!-- 제목 셀 -->
					<td><%=username%></td> <!-- 데이터 셀 -->
				</tr>
				<tr>
					<th scope="row">OPTION CHECK</th>
					<td><%=Arrays.toString(options1)%></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>