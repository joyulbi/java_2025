<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="form"   uri="http://www.springframework.org/tags/form"  %>
<%@ include  file="../inc/header.jsp" %>
<!--  header -->
<!--  header -->
   <div class="container  card  card-info  my-3  p-3">
      <h3 class="card-header"> WELCOME 로그인 </h3>
      <form:form   method="post"   action="${pageContext.request.contextPath}/member/login"    modelAttribute="memberLoginForm">
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
         <div class="my-3 text-center  "> 
            <button  type="submit"  class="btn btn-primary form-control">로그인</button>
         </div>   
      </form:form>
   </div>
<!--  footer -->
<!--  footer --> 
<%@ include  file="../inc/footer.jsp" %>