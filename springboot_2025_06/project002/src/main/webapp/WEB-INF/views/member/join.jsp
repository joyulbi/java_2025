<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="form"   uri="http://www.springframework.org/tags/form"  %>
<%@ include  file="../inc/header.jsp" %>
<!--  header -->
<!--  header -->
   <div class="container my-5 w-50">
      <h3 class="text-center mt-5"> WELCOME 회원가입 </h3>
      <form:form   method="post"   action="${pageContext.request.contextPath}/member/join"    modelAttribute="memberJoinForm">
         <%-- <form:errors  path="*"  cssClass="text-primary text-center"/>    --%>
         <div class="my-3">
            <label for="username">사용자ID</label>
            <form:input  path="username"   cssClass="form-control"/>
            <form:errors  path="username"  cssClass="text-primary"/>
         </div>    
         <div class="my-3">
            <label for="password">비밀번호</label>
            <form:input   path="password"   cssClass="form-control"/>
            <form:errors  path="password"  cssClass="text-primary"/>
         </div>   
         <div class="my-3">
            <label for="password2">비밀번호 확인</label>
            <form:input  path="password2"   cssClass="form-control"/>
            <form:errors  path="password2"  cssClass="text-primary"/>
         </div>   
         <div class="my-3">
            <label for="email">이메일</label>
            <form:input  path="email"   cssClass="form-control"/>
            <form:errors  path="email"  cssClass="text-primary"/>
         </div>   
         <div class="my-3 text-center  "> 
            <button  type="submit"  class="btn btn-primary form-control">회원가입</button>
         </div>   
      </form:form>
   </div>
<!--  footer -->
<!--  footer --> 
<%@ include  file="../inc/footer.jsp" %>