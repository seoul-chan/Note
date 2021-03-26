package com.home.controller;

import java.util.List;

import com.home.model.service.MemberService;
import com.home.model.vo.Board;
import com.home.model.vo.Member;
import com.home.view.MainView;

public class MemberController {
	MainView view;
	MemberService service = new MemberService();

	public void mainMenu() {
		view=new MainView();
		view.mainMenu(this);
	}
	
	public void memberTable() {
		view.memberTable();
	}
	
	public void mSearchAll() {
		List<Member> list=service.searchAll();
		view.mPrintAll(list);
	}
	
	public void mSearchId() {
		String id=view.mSearchId();
		List<Member> list=service.searchId(id);
		view.mPrintAll(list);
	}
	
	public void mSearchName() {
		String name=view.mSearchName();
		List<Member> list=service.searchName(name);
		view.mPrintAll(list);
	}
	
	public void mInsertMember() {
		Member m=view.mInsertMember();
		int result=service.insertMember(m);
		view.PrintMsg(result>0?"입력 성공":"입력 실패");
	}
	
	public void mUpdateMember() {
		Member m=view.mUpdateMember();
		int result=service.updateMember(m);
		view.PrintMsg(result>0?"수정 성공":"수정 실패");
	}
	
	public void mDeleteMember() {
		String id=view.mDeleteMember();
		int result=service.deleteMember(id);
		view.PrintMsg(result>0?"삭제 성공":"삭제 실패");
	}
}
