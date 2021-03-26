package com.home.controller;

import java.util.List;

import com.home.model.service.BoardService;
import com.home.model.vo.Board;
import com.home.view.MainView;

public class BoardController {
	MainView view;
	BoardService service = new BoardService();
	
	public void board(MainView view) {
		this.view=view;
		view.board();
	}
	
	public void bSearchAll() {
		List<Board> list=service.searchAll();
		view.bPrintAll(list);
	}
	
	public void bInsertPost() {
		Board b = view.bInsertPost();
		int result=service.insertPost(b);
		view.PrintMsg((result>0)?"입력 성공":"입력 실패");
	}
	
	public void bSearchWriter() {
		String name=view.bSearchWriter();
		List<Board> list=service.searchWriter(name);
		view.bPrintAll(list);
	}
	
	public void bSearchTitle() {
		String title=view.bSearchTitle();
		List<Board> list=service.searchTitle(title);
		view.bPrintAll(list);
	}
	
	public void bUpdatePost() {
		Board b=view.bUpdatePost();
		int result=service.updatePost(b);
		view.PrintMsg(result>0?"수정 성공":"수정 실패");
	}
	
	public void bDeletePost() {
		int idx=view.bDeletePost();
		int result=service.deletePost(idx);
		view.PrintMsg(result>0?"삭제 성공":"삭제 실패");
	}	
}
