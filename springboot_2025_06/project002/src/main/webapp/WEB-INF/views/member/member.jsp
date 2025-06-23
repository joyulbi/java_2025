<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../inc/header.jsp" %>
<!-- header -->
<!-- header -->
   <div class="container card card-info my-3 p-3">
      <h3 class="card-header">MYPAGE</h3>
      <table class="table table-striped table-bordered table-hover text-center">
         <caption>사용자 정보</caption>
         <tbody>
            <tr>
               <td colspan="2">
                  <img src="${dto.image}" alt="프로필이미지" class="rounded-circle" style="width:200px" />
               </td>
            </tr>
            <tr><th scope="row">닉네임</th><td>${dto.nickname}</td></tr>
            <tr><th scope="row">아이디</th><td>${dto.username}</td></tr>
            <tr><th scope="row">권한</th><td>${dto.role}</td></tr>
            <tr><th scope="row">이메일</th><td>${dto.email}</td></tr>
            <tr><th scope="row">회원가입경로</th><td>${dto.provider}</td></tr>
         </tbody>
      </table>
   </div>
<!-- footer -->
<!-- footer -->
<%@ include file="../inc/footer.jsp" %>