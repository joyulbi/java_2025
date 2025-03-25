<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setMaxInactiveInterval(10*60); // 10분동안
session.setAttribute("username", "sally"); // 세션 저장 이름, 값 
session.setAttribute("userage", "10");

response.sendRedirect("jsp021_session1.jsp");
%>