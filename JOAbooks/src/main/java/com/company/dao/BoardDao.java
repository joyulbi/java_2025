package com.company.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.dbmanager.DBManager;
import com.company.domain.BoardVO;

public class BoardDao {
//	 1. 글쓰기 - insert into board( btitle, bcontent, bname, bip ) values ( ?,?,?,? )
	public int insert(BoardVO vo) {
		String sql = "insert into board( btitle, bcontent, bname, bip ) values ( ?,?,?,? )";
		int result=-1;
		/////////////////////////////////////////////////////////
		DBManager db = new DBManager();
		Connection conn= null; PreparedStatement pstmt = null; //ResultSet rset =null;
		//DB연동
		conn=db.getConnection();
		//sql처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(3, vo.getBname());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {  e.printStackTrace();
		} finally {
			//if(rset != null) {try {rset.close();}catch(SQLException e) {e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
			if(conn != null) {try {conn.close();}catch(SQLException e) {e.printStackTrace();}}
		}
		/////////////////////////////////////////////////////////
		return result;
	}// end insert

//	 2. 최신글읽기 - select * from board order by bno desc
	public ArrayList<BoardVO> selectAll() {
		String sql = "select * from board order by bno desc";
		ArrayList<BoardVO> result = new ArrayList<>();
		/////////////////////////////////////////////////////////
		DBManager db = new DBManager();
		Connection conn= null; PreparedStatement pstmt = null; ResultSet rset =null;
		//DB연동
		conn=db.getConnection();
		//sql처리
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();//표
			while(rset.next()) {//줄
				result.add(new BoardVO(
						rset.getInt("bno"), rset.getString("btitle")
						,rset.getString("bcontent"),rset.getString("bname")
						,rset.getInt("bhit"),rset.getString("bdate")
						,rset.getString("bip")
						));
			}
		} catch (SQLException e) {  e.printStackTrace();
		} finally {
			if(rset != null) {try {rset.close();}catch(SQLException e) {e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
			if(conn != null) {try {conn.close();}catch(SQLException e) {e.printStackTrace();}}
		}
		/////////////////////////////////////////////////////////
		return result;
	}// end selectAll

//	 3. 해당글읽기/해당글 수정폼 - select * from board where bno=?
	public BoardVO select(int bno) {
		String sql = "select * from board where bno=?";
		BoardVO result = new BoardVO();
		/////////////////////////////////////////////////////////
		DBManager db = new DBManager();
		Connection conn= null; PreparedStatement pstmt = null; ResultSet rset =null;
		//DB연동
		conn=db.getConnection();
		//sql처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result=new BoardVO(
						rset.getInt("bno"), rset.getString("btitle")
						,rset.getString("bcontent"),rset.getString("bname")
						,rset.getInt("bhit"),rset.getString("bdate")
						,rset.getString("bip")
						);
			}
		} catch (SQLException e) {  e.printStackTrace();
		} finally {
			if(rset != null) {try {rset.close();}catch(SQLException e) {e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
			if(conn != null) {try {conn.close();}catch(SQLException e) {e.printStackTrace();}}
		}
		/////////////////////////////////////////////////////////
		return result;
	}// end select

//	 4. 조회수증가 - update board set bhit = bhit + 1 where bno=?
	public int updateHit(int bno) {
		String sql = "update board set bhit = bhit + 1 where bno=?";
		int result=-1;
		/////////////////////////////////////////////////////////
		DBManager db = new DBManager();
		Connection conn= null; PreparedStatement pstmt = null; //ResultSet rset =null;
		//DB연동
		conn=db.getConnection();
		//sql처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {  e.printStackTrace();
		} finally {
			//if(rset != null) {try {rset.close();}catch(SQLException e) {e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
			if(conn != null) {try {conn.close();}catch(SQLException e) {e.printStackTrace();}}
		}
		/////////////////////////////////////////////////////////
		return result;
	}// end updateHit

//	 5. 해당글수정 - update board set btitle=?,bcontent=? where bno=?
	public int update(BoardVO vo) { //넘겨 주는 값
		String sql = "update board set btitle=?,bcontent=? where bno=?";
		int result=-1;
		/////////////////////////////////////////////////////////
		DBManager db = new DBManager();
		Connection conn= null; PreparedStatement pstmt = null; //ResultSet rset =null;
		//DB연동
		conn=db.getConnection();
		//sql처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setInt(3, vo.getBno());
		} catch (SQLException e) {  e.printStackTrace();
		} finally {
			//if(rset != null) {try {rset.close();}catch(SQLException e) {e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
			if(conn != null) {try {conn.close();}catch(SQLException e) {e.printStackTrace();}}
		}
		/////////////////////////////////////////////////////////
		return result;
	}// end update

//	 6. 해당글삭제 - delete from board where bno=?
	public int delete(int bno) {
		String sql = "delete from board where bno=?";
		int result=-1;
		/////////////////////////////////////////////////////////
		DBManager db = new DBManager();
		Connection conn= null; PreparedStatement pstmt = null; //ResultSet rset =null;
		//DB연동
		conn=db.getConnection();
		//sql처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {  e.printStackTrace();
		} finally {
			//if(rset != null) {try {rset.close();}catch(SQLException e) {e.printStackTrace();}}
			if(pstmt != null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
			if(conn != null) {try {conn.close();}catch(SQLException e) {e.printStackTrace();}}
		}
		/////////////////////////////////////////////////////////
		return result;
	}// end delete

}
