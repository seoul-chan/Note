package com.home.model.service;

import static com.home.common.JDBCTemplate.getConnection;
import static com.home.common.JDBCTemplate.close;
import static com.home.common.JDBCTemplate.commit;
import static com.home.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.home.model.dao.BoardDao;
import com.home.model.vo.Board;

public class BoardService {
	BoardDao dao = new BoardDao();
	
	public List<Board> searchAll() {
		Connection conn = getConnection();
		List<Board> list=dao.searchAll(conn);
		close(conn);
		return list;
	}
	
	public int insertPost(Board b) {
		Connection conn=getConnection();
		int result=dao.insertPost(conn,b);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public List<Board> searchWriter(String name) {
		Connection conn = getConnection();
		List<Board> list=dao.searchWriter(conn,name);
		close(conn);
		return list;
	}
	
	public List<Board> searchTitle(String title) {
		Connection conn=getConnection();
		List<Board> list=dao.searchTitle(conn,title);
		close(conn);
		return list;
	}
	
	public int updatePost(Board b) {
		Connection conn=getConnection();
		int result=dao.updatePost(conn,b);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int deletePost(int idx) {
		Connection conn=getConnection();
		int result=dao.deletePost(conn,idx);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
}
