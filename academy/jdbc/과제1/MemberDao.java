package com.home.model.dao;

import static com.home.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.home.model.vo.Member;

public class MemberDao {
	private Properties prop=new Properties();
	
	public MemberDao() {
		try {
			prop.load(new FileReader("resource/sql/member_sql.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> searchAll(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList<Member>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchAll"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setIndex(rs.getInt("idx"));
				m.setId(rs.getString("member_id"));
				m.setPwd(rs.getString("member_pwd"));
				m.setName(rs.getString("member_name"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Member> searchId(Connection conn,String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList<Member>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchId"));
			pstmt.setString(1, "%"+id+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setIndex(rs.getInt("idx"));
				m.setId(rs.getString("member_id"));
				m.setPwd(rs.getString("member_pwd"));
				m.setName(rs.getString("member_name"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Member> searchName(Connection conn,String name) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList<Member>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchName"));
			pstmt.setString(1, "%"+name+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setIndex(rs.getInt("idx"));
				m.setId(rs.getString("member_id"));
				m.setPwd(rs.getString("member_pwd"));
				m.setName(rs.getString("member_name"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertMember(Connection conn,Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getPhone());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateMember(Connection conn,Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMember"));
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getAddress());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getId());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn,String name) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteMember"));
			pstmt.setString(1, name);
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
