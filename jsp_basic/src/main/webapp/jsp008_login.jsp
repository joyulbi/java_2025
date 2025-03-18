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
		<h3 class=></h3>
		<pre>
		1. 로그인폼 열기
		다음과 같이 설정 - 
		처리할 경로:jsp008_result.jsp
		주소표시창줄에 노출
		보관용기이름 :email/pass
		2.전송버튼을 누르면 다음과 같이 출력
		==LOGIN==
		EMAIL : first@gmail.com
		PASS : 1111
		[다시]
		</pre>
		<p style=" text-align:center"><img src = "images/login.png" alt="login"/></p>
		<form action="jsp008_result.jsp" method="get">
		  <div class="my-3">
		    <label for="email" class="form-label">Email : </label>
		    <input type="emial" class="form-control" id="email"
		           name="email"/>
		  </div>
		  <div class="my-3">
		    <label for="pass" class="form-label">Password : </label>
		    <input type="password" class="form-control" id="pass"
		           name="pass"/>
		  </div>
		  <div class="my-3">
		    <label for="check" class="form-label">Remember : </label>
		    <input type="checkbox" id="check" name="remember"
		    class="form-check-input"/>
		  </div>
		  <div class="my-3">
		  <input type="submit" title = "login 하러가기"
		  class = "btn btn-danger" id="check" name="remember"/>
		  </div>
		</form>
	</div>

</body>
</html>