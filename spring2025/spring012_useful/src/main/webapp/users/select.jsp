<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- users/select.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Spring 유용한기능</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-3">
		<div class="alert alert-warning"> NO   : ${dto.no} </div>
		<div class="alert alert-warning"> NAME : ${dto.name} </div>
		<div class="alert alert-warning"> AGE   : ${dto.age} </div>
	</div>
</body>
</html>


