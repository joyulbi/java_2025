<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>

<div class="container card  my-5  p-3">
	<h3>MULTIBOARD 상세보기</h3>
	<div class="my-3 ">
		<div class="">
			<span><i class="bi bi-book"></i> 조회수</span>
			<p></p>
		</div>
	</div>
	<div class="my-3">
		<div class="">
			<span><i class="bi bi-book-half"></i></i> 이름</span>
			<p></p>
		</div>
	</div>
	<div class="my-3">
		<div class="">
			<span><i class="bi bi-book"></i> 제목</span>
			<p></p>
		</div>
	</div>
	<div class="my-3">
		<div class="">
			<span><i class="bi bi-book-half"></i></i> 내용</span>
			<p></p>
		</div>
	</div>
	<div class="text-end">
		<a href="" class="btn btn-primary my-3" style="display:block">수정</a> 
		<a href=""class="btn btn-primary my-3" style="display:block">삭제</a> 
		<a href="list.jsp"class="btn btn-outline-primary my-3"style="display:block">목록보기</a>
	</div>
</div>

<%@ include file="../inc/footer.jsp"%>