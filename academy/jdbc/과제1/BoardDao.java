package com.home.model.dao;

import static com.home.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.home.model.vo.Board;

public class BoardDao {
	
	private Properties prop=new Properties();
	
	public BoardDao(){
		try {
			prop.load(new FileReader("resource/sql/board_sql.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Board> searchAll(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> list=new ArrayList<Board>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectAll"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b=new Board();
				b.setIdx(rs.getInt("idx"));
				b.setDiv(rs.getString("div"));
				b.setTitle(rs.getString("title"));
				b.setContests(rs.getString("contents"));
				b.setWriter(rs.getInt("writer"));
				list.add(b);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertPost(Connection conn,Board b) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertPost"));
			pstmt.setString(1,b.getDiv());
			pstmt.setString(2,b.getTitle());
			pstmt.setString(3,b.getContests());
			pstmt.setInt(4,b.getWriter());

			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<Board> searchWriter(Connection conn,String writer) {
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		List<Board> list=new ArrayList<Board>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchWriter"));
			pstmt.setString(1, writer);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b=new Board();
				b.setIdx(rs.getInt("idx"));
				b.setDiv(rs.getString("div"));
				b.setTitle(rs.getString("title"));
				b.setContests(rs.getString("contents"));
				b.setWriter(rs.getInt("writer"));
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Board> searchTitle(Connection conn,String title) {
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		List<Board> list=new ArrayList<Board>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchTitle"));
			pstmt.setString(1, "%"+title+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b=new Board();
				b.setIdx(rs.getInt("idx"));
				b.setDiv(rs.getString("div"));
				b.setTitle(rs.getString("title"));
				b.setContests(rs.getString("contents"));
				b.setWriter(rs.getInt("writer"));
				list.add(b);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int updatePost(Connection conn,Board b) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updatePost"));
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContests());
			pstmt.setInt(3, b.getIdx());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deletePost(Connection conn,int idx) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deletePost"));
			pstmt.setInt(1, idx);
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
