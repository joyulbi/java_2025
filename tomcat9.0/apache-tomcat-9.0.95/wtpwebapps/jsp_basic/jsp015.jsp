<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card bg-info my-5">
		<h3 class="card-header text-white">내장객체</h3>
		<pre style="background-color: white">
		1. jsp 페이지가 웹컨테이너에 의해 서블릿으로 변환 될 때
		2. 고정된 이름의 객체 컨테이너로 자동으로 구현
		3. request(요청) , response(응답), session(정보저장), out(출력)
		</pre>
	</div> <!-- 내장객체안내 -->

	<div class="container card my-5">
		<h3 class="card-header bg-info text-white">request(요청)</h3>
		<pre>
		1. action = "처리 컴포넌트"
		2. method = "처리 방식"
		3. name = "사용자가 입력한 값 보관 이름"
		</pre>
		<form action="jsp015_checkbox.jsp" method="get" onsubmit="return checkbox()">
			<div class="mb-3 mt-3">
				<label for="username" class="form-label">NAME:</label> <input
					type="text" class="form-control" id="username"
					placeholder="Enter email" name="username">
			</div>
			<!-- user name -->
			<div class="form-check">
				<input class="form-check-input" type="checkbox" id="check1"
					name="option1" value="dog"> <label
					class="form-check-label" for="check1">DOG</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" id="check2"
					name="option1" value="cat" > <label
					class="form-check-label" for="check2">CAT</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" id="check3"
					name="option1" value="pig" > <label
					class="form-check-label" for="check3">PIG</label>
			</div>
			<div class="my-3">
				<button type="submit" class="btn btn-primary">전송</button>
			</div>
		</form>
		<script> <!-- username 유효성 검사-->
			function checkbox(){
				let username = document.getElementById("username");
				let checkboxs = document.querySelectorAll(".form-check-input:checked"); // 다중선택
				console.log(checkboxs);
				console.log(checkboxs.length);
				
				if(username.value===""){
					alert("빈칸입니다.");
					username.focus(); return false;
				}
				if(checkboxs.length == 0){
					alert("체크박스를 한 개 이상은 체크하셔야 합니다.");
					return false;
				}
			}
		</script>
	</div> <!-- end checkbox -->


	<div class="container card my-5">
		<h3 class="card-header bg-info text-white">request(요청)-radio</h3>
		<form action="jsp015_radio.jsp" method="get" onsubmit="return check2()">
			<div class="mb-3 mt-3">
				<label for="username1" class="form-label">NAME:</label> <input
					type="text" class="form-control" id="username1"
					placeholder="사용자 이름을 적어주세요!" name="username">
			</div> <!-- user name -->
			
			<!-- radio -->
			<!-- radio -->
			<div class="form-check">
				<input type="radio" class="form-check-input1" id="radio1" style="margin-right:10px"
					name="optradio" value="yes">yes
					<label class="form-check-label" for="radio1"></label>
			</div>
			<div class="form-check">
				<input type="radio" class="form-check-input1" id="radio2" style="margin-right:10px"
					name="optradio" value="no">no<label
					class="form-check-label" for="radio2"></label>
			</div>
			<div class="form-check">
				<input type="radio" class="form-check-input1" style="margin-right:10px" disabled>사용 못함-disabled
				<label class="form-check-label"></label>
			</div>
			<!-- radio -->
			<!-- radio -->

			<div class="my-3">
				<button type="submit" class="btn btn-primary">전송</button>
			</div>
		</form>
		<script>
			function check2(){
				let username1=document.querySelector("#username1");
				let radios = document.querySelectorAll(".form-check-input1:checked");
				console.log(radios.length);
				
				if(username1.value===""){
					alert("빈칸입니다."); username1.focus(); return false;
				}
				if(radios.length==0){
					alert("라디오 박스를 한 개 이상은 선택하세요"); return false;
				}
			}
		</script>
	</div> <!-- end radio -->
	
	<div class="container card my-5">
		<h3 class="card-header bg-info text-white">request(요청)-select</h3>
		
		<form action="jsp015_select.jsp" method="get" onsubmit="return check3()">
			<div class = "mb-3 mt-3" >
			<label for="username3" class="form-label">NAME:</label>
			<input type="text" class="form-control" id="username3"
				placeholder="사용자 이름을 적어주세요!" name="username">
			</div><!-- username -->
			
			<!-- select -->
			<!-- select -->
			<label for="color">COLOR 선택 :</label>
			<select class="form-select" id="color" name="color">
				<option value="bg-danger">RED</option>
				<option value="bg-success">GREEN</option>
				<option value="bg-primary">BLUE</option>
				<option value="bg-dark">BLACK</option>
			</select>
			<!-- select -->
			<!-- select -->
			
			<div class="my-3">
				<button type="submit" class="btn btn-primary">전송</button>
			</div>
		</form>
		<script>
		function check3(){
			let username3=document.querySelector("#username3")
			let color =document.querySelector("#color>option:checked");
			
			
			if(username3.value===""){
				alert("빈칸입니다");
				username3.focus(); return false;
			}
			if(color.value==""){
				alert("빈칸입니다"); color.focus(); return false;
			}
		}
		</script>
	</div>
</body>
</html>