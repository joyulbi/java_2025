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
<%@ include file="../inc/header.jsp"%>
	<div class="container m-auto text-align">
		<h3 class="card-header text-center mt-3">MULTIBOARD-글수정</h3>
		<form action="/action_page.php">
			<div class="mb-3 mt-3">
				<label for="name" class="form-label">이름:</label> <input
					type="text" class="form-control" id="name"
					placeholder="이름을 입력하세요." name="name">
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">제목:</label> <input
					type="text" class="form-control" id="content"
					placeholder="Enter password" name="pswd">
			</div>
			<label for="comment">내용:</label>
			<textarea class="form-control" rows="5" id="comment" name="text"></textarea>
			<div class="d-grid gap-2 mt-3">
			<button type="submit" class="btn btn-primary  ">Submit</button>
			<button type="reset" class="btn btn-outline-secondary">취소</button>
            <a href="list.jsp" class="btn btn-outline-secondary mb-3">목록보기</a>
            </div>
		</form>
		
		<script>
		
		</script>
		
		
	</div>
</body>
</html>
<%@ include file="../inc/footer.jsp"%>