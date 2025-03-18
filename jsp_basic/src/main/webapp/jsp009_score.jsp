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
        <h3 class="card-header">FORM BASIC - SCORE</h3>
        <pre class ="my-3">
        처리할 경로 : jsp009_result.jsp
        주소표시창줄에 노출 X
        보관용기 이름 : kor / eng /math
        </pre>
        <div class="card-body">
            <form action="jsp009_result.jsp" method="post">
                <div class="mb-3">
                    <label for="kor" class="form-label">국어 점수:</label>
                    <input type="number" class="form-control" id="kor" name="kor" min="0" max="100">
                </div>
                <div class="mb-3">
                    <label for="eng" class="form-label">영어 점수:</label>
                    <input type="number" class="form-control" id="eng" name="eng" required>
                </div>
                <div class="mb-3">
                    <label for="math" class="form-label">수학 점수:</label>
                    <input type="number" class="form-control" id="math" name="math" required>
                </div>
                <div class="my-3" style="text-align:right">
               <input type="submit"class="btn btn-success" title="성적처리하러가기" value="성적처리"/></div>
             <!-- <button type="submit" class="btn btn-primary">성적처리 프로그램</button> --> 
            </form>
        </div>
    </div>
</body>
</html>