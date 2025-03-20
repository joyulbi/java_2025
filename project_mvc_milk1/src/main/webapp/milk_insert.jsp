<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	
	//2. request.getParameter() 이용해서 데이터받기
	String oname = request.getParameter("oname");
	int onum = Integer.parseInt(request.getParameter("onum"));
	//out.println(oname+"/"+onum);
	
	Connection conn = null; PreparedStatement pstmt = null;
	String sql="insert into milk_order(oname,onum,oip) values(?,?,?); "; //##
	try{
		//3. Driver연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		//4. DB 연동
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
		out.println("db연동성공"+conn);
		//5. PreparedStatement 이용해서 sql처리
		pstmt=conn.prepareStatement(sql); //##
		pstmt.setString(1,oname);//1,oname	-> 첫번째 물음표, 값
		pstmt.setInt(2,onum);//2,onum	-> en번째 물음표, 값
		pstmt.setString(3, InetAddress.getLocalHost().getHostAddress());
		
		//6. 결과 값 받아서 처리
		int result = pstmt.executeUpdate(); //sql-INSERT, UPDATE or DELETE;실행준수
		
		if(result>0){out.println("<script>alert('주문성공!'); location.href='milk.jsp'; </script>");}
		else{out.println("<script>alert('주문성공!'); location.href='milk.jsp'; </script>");}
	}catch(Exception e){e.printStackTrace();
	}finally{
		//if(rset != null){rset.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
		
	}

%>

<%--
//1. utf-8 설정
//2. request.getParameter() 이용해서 데이터받기
//3. Driver연동
//4. DB 연동
//5. PreparedStatement 이용해서 sql처리
//6. 결과 값 받아서 처리
--%>