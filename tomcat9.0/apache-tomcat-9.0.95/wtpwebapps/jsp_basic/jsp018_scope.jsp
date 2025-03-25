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
		<h3 class ="card-header"> 내장객체 유효범위 </h3>
		<pre class="alert alert-warning my-3">
		application (웹애플리케이션 실행되고 있는동안) >session(브라우저 종료) > request(요청) > page(해당페이지)
		</pre>
		<%
		application.setAttribute("name","D.application - 웹 애플리케이션 실행");
		session.setAttribute("name","C.session - 브라우저 종료/로그인 후 아이디 유지");
		request.setAttribute("name","B.request - a.jsp -> b.jsp 요청할때");
		pageContext.setAttribute("name","A.현재페이지에서만 유지");
		%>
		<table class="table table-striped">
			<caption>SCOPE- 내장객체 유효범위</caption>
			<tbody>
			<tr><th scope ="row">page</th><td><%=pageContext.getAttribute("name") %></td></tr>
			<tr><th scope ="row">request</th><td><%=request.getAttribute("name") %></td></tr>
			<tr><th scope ="row">session</th><td><%=session.getAttribute("name") %></td></tr>
			<tr><th scope ="row">application</th><td><%=application.getAttribute("name") %></td></tr>
			</tbody>
		</table>
			<p><a href="jsp018_2.jsp?a=1" class="btn btn-danger">SCOPE2</a></p>
	</div>
</body>
</html>