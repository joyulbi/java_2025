<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//jsp022_logout.jsp
	//1. session 초기화 코드
	//2. login.jsp 페이지로 넘기기 (10초뒤에-안내)
	session.invalidate();
	
	// >>>> 경로 바로 넘기기
	//ver-1 out.println("<script>alert('로그아웃합니다');location.href='jsp022_login.jsp';'</script>");
	
	//ver-2
	//out.println("<script>alert('로그아웃합니다');</script>"); //동작안함
	//response.sendRedirect("jsp022_login.jsp"); //알림창 처리안됨
	
	//ver-3 새로고침 http-equiv='refresh'	content='초; url=경로'
	out.println("<meta http-equiv='refresh' content='2; url='jsp022_login.jsp'/>");
	
	// >>>> sendRedirect (request,response 유지 안됨.) / dispatcher의 차이점??
	//request.getRequestDispatcher("jsp022_my.jsp").forward(request,response);
%>
