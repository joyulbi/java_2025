<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
 	//1. 데이터값 넘겨받기
 	String name = request.getParameter("name");
 	String pass = request.getParameter("pass");
 	//2. 드라이버연동 
 	//3. db연동 
 	Connection conn = null; PreparedStatement pstmt=null; ResultSet rset = null;
 	String sql="select count(*) 'cnt' from member where name=? and pass=?";
 	
 	int result = -1;
 	try{
 		Class.forName("com.mysql.cj.jdbc.Driver");
 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
 		//if(conn!=null) { out.println("db연동성공!");}
 		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pass);
		rset = pstmt.executeQuery();
		if (rset.next()){result=rset.getInt("cnt");}
 		
		if(result==1){ //아이디와 비밀번호가 같은 사람 1명
			request.getRequestDispatcher("jsp022_my.jsp").forward(request, response);
		}else{
			out.println("<script>alert('정보를 확인해주세요'); history.go(-1); </script>");
		}
 		
 	 	// 찾았으면 [경로안바뀌게] , 보이는 화면은 jsp022_my.jsp 페이지로 넘어가기 / 
 	 	// 못찾았으면 정보를 확인해주세요~ 알림창띄우고 로그인페이지로  jsp022_login.jsp 페이지
	}catch (Exception e){ e.printStackTrace(); 
 	}finally{
 		if(rset != null){rset.close();}
 		if(pstmt != null){pstmt.close();}
 		if(conn != null){conn.close();}
 	}
%>


