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
		<h3 class ="card-header">PreparedStatement</h3>
		<pre>
		1) 드라이버 로딩 Class.forName
		2) db연동 	  DriveManger.getConnection(url, id, pass);
		3) Statement, PreparedStatement
		4) 결과 : Result (select) / int (insert, update, delete)
		</pre>
		<%@page import="java.sql.*" %>
		<%
		Connection conn =null; PreparedStatement pstmt =null; ResultSet rset = null;
		String sql = "select *from userinfo where mname=?";
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String id="root",pass="1234";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,id,pass);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"white");//1. -?의 번호 1부터 시작함
			//pstmt.setInt(2,1);// 2. -두번째 물음효
			//표 줄 칸
			rset = pstmt.executeQuery(); //표 
			while(rset.next()){//해당 데이터 가져오기
				out.println(rset.getInt("no")+"/"+rset.getString("name")+"/"+rset.getString("name"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rset != null){rset.close();}
			if(pstmt != null){pstmt.close();}
			if(conn != null){conn.close();}
		}
		%>
	</div>
</body>
</html>