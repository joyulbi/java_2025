<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="ko">
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
		<h3 class="card-header  bg-info text-white">response</h3>
		<pre class="alert alert-warning my-2">
		내장객체 : response
		javax.servlet.ServletResponse(  javax.servlet.http.HttpResponse )
		- Http요청에 대한 응답정보를 저장한 객체
		- 응답처리를 하는객체인 response는 실행결과를 브라우저로 되돌려줄때 사용하는 내장객체
		- jsp에서 다른페이지로 이동시키는방법 :  
		   (1)   sendRedierct   - 브라우저 url을 변경 , request/response객체가 유지되지 않음 
		   (2)   RequestDispatcfher - 경로가 숨겨져서 안보임
		</pre>
		
		<pre>
		respones.jsp (1) →  jsp016_2.jsp 처리 (2)
		
								19세 미만이라면 - jsp016_child.jsp
								19세 이상이라면 - 보여주는 주소표시창줄은 jsp016_2.jsp
											   보이는 화면은 jsp016_adult.jsp
								
		</pre>
		
		<form  action="jsp016_2.jsp"  method="get" onsubmit="return form()"> 
			<div class="mb-3 mt-3">
					<label for="userage">나이입력</label>
					<input type="text"  id="userage"   name="userage"    class="form-control" />
			</div>
			<div class="mb-3 mt-3">
				<input type="submit"  value="성인여부"  class="btn btn-danger" />
			</div> 
		</form>
		<script>
			function form(){
				let userage = document.querySelector("#userage");
				if(userage.value==""){
					alert("빈칸입니다."); userage.focus(); return false;
				}
			}
		</script>
	</div>
</body>
</html>
 