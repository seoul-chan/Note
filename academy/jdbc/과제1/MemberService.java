package com.home.model.service;

import static com.home.common.JDBCTemplate.getConnection;
import static com.home.common.JDBCTemplate.close;
import static com.home.common.JDBCTemplate.commit;
import static com.home.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.home.model.dao.MemberDao;
import com.home.model.vo.Member;

public class MemberService {
	MemberDao dao=new MemberDao();

	public List<Member> searchAll() {
		Connection conn = getConnection();
		List<Member> list = dao.searchAll(conn);
		close(conn);
		return list;
	}
	
	public List<Member> searchId(String id) {
		Connection conn = getConnection();
		List<Member> list = dao.searchId(conn,id);
		close(conn);
		return list;
	}
	
	public List<Member> searchName(String name) {
		Connection conn = getConnection();
		List<Member> list = dao.searchName(conn,name);
		close(conn);
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result=dao.insertMember(conn,m);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result=dao.updateMember(conn,m);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int deleteMember(String id) {
		Connection conn = getConnection();
		int result=dao.deleteMember(conn,id);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;		
	}	
}
