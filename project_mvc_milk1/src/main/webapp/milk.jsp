<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>MILK ORDER Project</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

<%
  // DataSource JNDI 연결 (공통으로 사용하도록 설정)
  Context initContext = new InitialContext();
  Context envContext  = (Context)initContext.lookup("java:/comp/env");
  DataSource ds = (DataSource)envContext.lookup("jdbc/mbasic");
  Connection conn1 = ds.getConnection();
  if(conn1!=null){out.println("연동성공!");}
%>



<div class="p-5 bg-danger text-white">
  <h1>MILK ORDER Project</h1>
  <p>PreparedStatement Ex</p>
</div>

<!-- 메뉴판 -->
<div class="container card my-5">
  <h3 class="card-header bg-danger text-white">Milk Menu</h3>
  <table class="table table-bordered table-striped table-hover table-dark my-5">
    <caption>우유메뉴</caption>
    <thead>
      <tr>
        <th scope="col">NO</th>
        <th scope="col">NAME</th>
        <th scope="col">PRICE</th>
      </tr>
    </thead>
    <tbody>
    <%
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
        pstmt = conn.prepareStatement("SELECT * FROM milk");
        rset = pstmt.executeQuery();
        while (rset.next()) {
    %>
      <tr>
        <td><%=rset.getInt("mno")%></td>
        <td><%=rset.getString("mname")%></td>
        <td><%=rset.getInt("mprice")%></td>
      </tr>
    <%
        }
      } catch(Exception e) {
        e.printStackTrace();
      } finally {
        if(rset != null) rset.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
      }
    %>
    </tbody>
  </table>
</div>

<!-- 주문현황 -->
<div class="container card my-5 bg-danger">
  <h3 class="card-header bg-danger text-white">MILK ORDER</h3>
  <table class="table table-striped table-bordered table-hover">
    <caption>milk 주문현황</caption>
    <thead>
      <tr>
        <th scope="row">NO</th><th scope="row">NAME</th><th scope="row">NUM</th><th>주문날짜</th>
      </tr>
    </thead>
    <tbody>
    <%
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
        String sql = "SELECT * FROM milk_order ORDER BY ono DESC";
        pstmt = conn.prepareStatement(sql);
        rset = pstmt.executeQuery();
        while (rset.next()) {
          out.println("<tr><td>" + rset.getInt("ono") + "</td><td>" + rset.getString("oname") +
                      "</td><td>" + rset.getInt("onum") + "</td><td>" + rset.getString("odate") + "</td></tr>");
        }
      } catch(Exception e) {
        e.printStackTrace();
        out.println("<p>데이터를 불러오는 중 오류가 발생했습니다.</p>");
      } finally {
        if(rset != null) rset.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
      }
    %>
    </tbody>
  </table>
</div>

<!-- 주문 입력/수정/삭제 폼 -->
<div class="container card bg-danger my-5">
  <h3 class="card-header bg-danger text-white my-3">MILK 주문하러가기</h3>
  <div id="accordion"> 

    <!-- 주문하기 -->
    <div class="card my-3">
      <div class="card-header bg-warning text-info">
        <a class="btn text-white" data-bs-toggle="collapse" href="#collapseOne" style="font-weight:bold; font-size:120%">주문하기</a>
      </div>
      <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
        <div class="card-body">
          <form action="milk_insert.jsp" method="post" onsubmit="return checkInsertBlank()">
            <div class="mb-3 mt-3">
              <label for="email" class="form-label">주문할 우유이름</label>
              <input type="text" class="form-control" id="email" name="oname" placeholder="우유 이름을 적어주세요!">
            </div>
            <div class="mb-3">
              <label for="pwd" class="form-label">주문할 우유갯수</label>
              <input type="number" class="form-control" id="pwd" name="onum" placeholder="우유 갯수를 적어주세요!">
            </div>
            <button type="submit" class="btn btn-danger">주문하기</button>
          </form>
        </div>
      </div>
    </div>

    <!-- 주문수정 -->
    <div class="card my-3">
      <div class="card-header bg-warning">
        <a class="collapsed btn text-white" data-bs-toggle="collapse" href="#collapseTwo" style="font-weight:bold;">주문수정</a>
      </div>
      <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
        <div class="card-body">
          <form action="milk_update.jsp" method="post" onsubmit="return checkUpdateBlank()">
            <div class="mb-3 mt-3">
              <label class="form-label">수정 주문번호</label>
              <input type="number" class="form-control" id="ono_update" name="ono" placeholder="주문번호 입력">
            </div>
            <div class="mb-3">
              <label class="form-label">수정할 우유 이름</label>
              <input type="text" class="form-control" id="oname_update" name="oname" placeholder="우유 이름 입력">
            </div>
            <div class="mb-3">
              <label class="form-label">수정할 우유 갯수</label>
              <input type="number" class="form-control" id="onum_update" name="onum" placeholder="갯수 입력">
            </div>
            <button type="submit" class="btn btn-danger">주문수정하기</button>
          </form>
        </div>
      </div>
    </div>

    <!-- 주문삭제 -->
    <div class="card my-3">
      <div class="card-header bg-warning">
        <a class="collapsed btn text-white" data-bs-toggle="collapse" href="#collapseThree" style="font-weight:bold;">주문삭제</a>
      </div>
      <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
        <div class="card-body">
          <form action="milk_delete.jsp" method="post" onsubmit="return checkDeleteBlank()">
            <div class="mb-3">
              <label class="form-label">취소 주문번호</label>
              <input type="number" class="form-control" id="ono_delete" name="ono" placeholder="취소할 주문번호 입력">
            </div>
            <button type="submit" class="btn btn-danger">주문 삭제하기</button>
          </form>
        </div>
      </div>
    </div>

  </div>
</div>

<!-- 유효성 검사 -->
<script>
  function checkInsertBlank() {
    let name = document.querySelector("#email");
    let num = document.querySelector("#pwd");
    if (name.value === "") {
      alert("우유 이름을 입력하세요.");
      name.focus();
      return false;
    }
    if (num.value === "" ) {
      alert("우유 갯수를 올바르게 입력하세요.");
      num.focus();
      return false;
    }
    return true;
  }

  function checkUpdateBlank() {
    let ono = document.querySelector("#ono_update");
    let name = document.querySelector("#oname_update");
    let num = document.querySelector("#onum_update");
    if (ono.value=== "" || isNaN(ono.value)) {
      alert("주문번호를 입력하세요.");
      ono.focus();
      return false;
    }
    if (name.value=== "") {
      alert("수정할 우유 이름을 입력하세요.");
      name.focus();
      return false;
    }
    if (num.value=== "") {
      alert("수정할 갯수를 올바르게 입력하세요.");
      num.focus();
      return false;
    }
    return true;
  }

  function checkDeleteBlank() {
    let ono = document.querySelector("#ono_delete");
    if (ono.value === "" ) {
      alert("취소할 주문번호를 입력하세요.");
      ono.focus();
      return false;
    }
    return true;
  }
</script>
</body>
</html>