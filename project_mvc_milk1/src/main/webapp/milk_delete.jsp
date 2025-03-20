<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
    // 1. UTF-8 설정
    request.setCharacterEncoding("UTF-8");

    // 2. 사용자가 입력한 주문번호 받기
    int ono = Integer.parseInt(request.getParameter("ono")); // 삭제할 주문번호

    // 값 출력 (디버깅용)
    out.println("삭제할 주문번호: " + ono + "<br>");

    // 3. MySQL 드라이버 연동 및 DB 연결
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 4. DB 연결 (본인의 DB 정보에 맞게 수정)
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");

        // 5. SQL DELETE 문 작성
        String sql = "DELETE FROM milk_order WHERE ono = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ono); // 사용자가 입력한 주문번호 설정

        // 6. DELETE 실행
        int rowsDeleted = pstmt.executeUpdate();

        if (rowsDeleted > 0) {
            out.println("<script>alert('주문이 삭제되었습니다.'); location.href='milk.jsp';</script>");
        } else {
            out.println("<script>alert('삭제할 주문을 찾을 수 없습니다.'); location.href='milk.jsp';</script>");
        }

    } catch (Exception e) {
        e.printStackTrace();
        out.println("<script>alert('오류가 발생했습니다.'); history.back();</script>");
    } finally {
        // 7. DB 연결 종료
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>
