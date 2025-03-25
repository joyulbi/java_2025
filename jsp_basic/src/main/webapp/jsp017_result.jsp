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
		<h3 class ="card-header">SELECT BOX</h3>
		
		<%
		String username = request.getParameter("username");
		String fruit = request.getParameter("fruit");
		String btn = fruit.equals("apple")? "btn-danger"
					:fruit.equals("banana")? "btn-warning"
					:"btn-success";
		%>
		<table class="table table-striped p-5">
		<caption>SELECT 데이터확인</caption>
			<tbody>
				<tr>
					<th scope="row">유저정보</th>
					<td><%=username%></td>
				</tr>
				<tr>
					<td class="text-white p-5">
					<img alt="<%=fruit%>" src="images/<%= fruit %>.png" width="200" height="200"></td>
				</tr>
			</tbody>
		</table>
		<a href="jsp017.jsp" class="btn <%=btn%> m-5">BACK</a>
	</div>
</body>
</html>