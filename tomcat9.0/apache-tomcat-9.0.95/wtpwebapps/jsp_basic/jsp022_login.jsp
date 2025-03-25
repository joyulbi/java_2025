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
		<div class="my-5"><%=session.getAttribute("username")%></div>
		
		<h3 class="card-header bg-warning text-white">LOGIN</h3>
		<p style=" text-align:center"><img src = "images/login.png" alt="login"  class="mt-3"/></p>
		<form action="jsp022_login_action.jsp" method="post" onsubmit="return check1()">
		  <div class="my-3">
		    <label for="name" class="form-label">아이디 : </label>
		    <input type="text" class="form-control" id="name"
		           name="name"/>
		  </div>
		  <div class="my-3">
		    <label for="pass" class="form-label">비밀번호 : </label>
		    <input type="password" class="form-control" id="pass"
		           name="pass"/>
		  </div>
		  <div class="my-3">
		    <label for="check" class="form-label">아이디 기억하기 : </label>
		    <input type="checkbox" id="check" name="remember"
		    class="form-check-input"/>
		  </div>
		  <div class="my-3 text-end">
		  <input type="submit" value="LOGIN" title = "login 하러가기"
		  class = "btn btn-danger" id="check" name="remember"/>
		  </div>
		</form>
		<script>
			function check1(){
				let name = document.querySelector("#name");
				let pass = document.querySelector("#pass");
				if(name.value===""){
					alert("아이디를 입력하세요.");
					name.focus(); return false;
				}
				if(pass.value===""){
					alert("비밀번호를 입력하세요.");
					pass.focus();
					return false;
				}
			}
		</script>
	</div>
</body>
</html>