package jsp023_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class jsp025_login
 */
@WebServlet("/user_login")
public class jsp025_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsp025_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		int result=-1;
		DBManager db = new DBManager();
		Connection conn = db.getConnection(); PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "select count(*) 'cnt' from member where name = ? and pass = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
	        pstmt.setString(2, pass);
	        
	        rset = pstmt.executeQuery();
	        if (rset.next()) {result=rset.getInt("cnt");}
	        	System.out.println(3);
	        if (result== 1) {
	        	HttpSession session = request.getSession();
				session.setAttribute("username", name);
				//response.sendRedirect("jsp025_my.jsp");
				out.println("<script>alert('로그인 성공!'); location.href='jsp025_my.jsp';</script>");
	        }else {
	         out.println("<script>alert('정보를 확인해주세요.'); history.back(-1);</script>");
            }
	        
			
		}catch(Exception e){
			
		}finally {
            try { if (rset != null) rset.close(); } catch (SQLException e) {e.printStackTrace();}
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {e.printStackTrace();}
            try { if (conn != null) conn.close(); } catch (SQLException e) {e.printStackTrace();}
        }
		

		

	}
}






