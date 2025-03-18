<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
		<h3 class ="card-header"> MY SEARCH </h3>
		<pre>
		1. action    : jsp007_result.jsp
		2. method    : get
		3. 입력보관이름 : para
		</pre>
		<form action="jsp007_result.jsp" method="get">
		  <div class="my-3">
		    <label for="query" class="form-label">검색어</label>
		    <input type="text" class="form-control" id="query"
		           name="para"/>
		 
		  <button type="submit" class="btn btn-danger">Submit</button>
		 </div>
		</form>
	</div>
</body>
</html>

<!-- jsp004_request -->