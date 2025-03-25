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
		<h3 class ="card-header">쿠키 값 삭제</h3>
		<%
		//1. 쿠키 값 있는지 확인
		String cookie =request.getHeader("Cookie");
		//2. null이 아니라면 시간을 0으로 설정
		//3. 브라우저에 탑재해서 확인
		if(cookie != null){
			Cookie[] coookies = request.getCookies();
			for(Cookie c: coookies){
				c.setMaxAge(0); response.addCookie(c);
			} //쿠키의 유효시간 0
		}
		
		response.sendRedirect("jsp020_cookie1.jsp");
		%>
	</div>
</body>
</html>