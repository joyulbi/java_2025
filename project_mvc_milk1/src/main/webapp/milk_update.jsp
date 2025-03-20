<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
	// 1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	// 2. request.getParameter()이용해서 데이터받기 (ono,oname,onum)
	int ono = Integer.parseInt(request.getParameter("ono"));
	String oname = request.getParameter("oname");
	int onum = Integer.parseInt(request.getParameter("onum"));
	out.println(ono+"/"+oname+"/"+onum);
	
	 Connection conn = null;PreparedStatement pstmt = null;
	 String sql = "update milk_order set oname = ?, onum = ? where ono = ?";
	try {
		// 3. Driver 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 4. DB 연동 - close()
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
		// 5. PreparedStatement 이용해서 sql처리
		pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, oname);  // 새로운 우유 이름
        pstmt.setInt(2, onum);  // 새로운 주문 개수
        pstmt.setInt(3, ono);  // 수정할 주문번호
		// 6. 결과 값 받아서 처리
        if (pstmt.executeUpdate() > 0) {
            out.println("<script>alert('수정성공!'); location.href='milk.jsp';</script>");
        } else {
            out.println("<script>alert('수정실패'); location.href='milk.jsp';</script>");
        }
	}catch (Exception e) {e.printStackTrace();
	}finally {
        // 7. DB 연결 종료
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>