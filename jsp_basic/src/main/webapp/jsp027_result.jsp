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
		<h3 class ="card-header">001. el ( 표현식 ) </h3>
		<p> <%out.println("hello"); %> </p>
		<p> <%="hello"%> </p>
		<p> ${"hello"} ${1} ${3.14} ${'A'} ${"ABC"} </p>
		<p><a href="jsp027_result.jsp?name=sally">PARM</a></p>
	</div>
</body>
</html>