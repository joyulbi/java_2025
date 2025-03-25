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
<body> <!-- jsp021_session1.jsp -->
	<div class="container card my-5">
		<h3 class ="card-header">세션 - 서버측에 저장되는 정보</h3>
		<table class="table table-striped table-bordered table-hover my-3">
			<caption>SESSION</caption>
			<tbody>
			<%
				String username = (String)session.getAttribute("username"); // Object
				String userage = (String)session.getAttribute("userage");
				out.println("<tr><td>"+username+"</td><td>"+userage+"</td></tr>");
			%>
			</tbody>
		</table>
		
		<div class="text-center">
			<a href="jsp021_session2.jsp" class="btn btn-danger">세션 값 저장</a>
			<a href="jsp021_session3.jsp" class="btn btn-danger">세션 값 삭제</a>
			<a href="jsp021_session4.jsp" class="btn btn-danger">세션 값 초기화</a>
		</div>
	</div>
</body>
</html>