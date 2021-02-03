package com.member.controller;

import com.member.model.dao.MemberDao;
import com.member.model.view.MainView;
import com.member.model.vo.Member;

public class MemberController {
	
	MainView view = new MainView();
	MemberDao dao = new MemberDao();
	
	public void mainMenu() {
		view.mainMenu(this);
	}
	
	//1. 전체회원 조회
	public void serchAll() {
		String search = dao.serchAll();
		view.resultPrint(search.equals("")?"입력한 정보가 없습니다.":search);
	}
	
	//2. 회원 등록
	public void insertMember() {
		Member mem = view.insetMember();
		boolean flag = dao.insertMember(mem);
		view.resultPrint(flag?"등록 성공":"등록 실패");
	}
	
	//3. 아이디로 회원 조회
	public void serchId() {
		String id = view.serchId();
		String flag = dao.serchId(id);
		
		view.resultPrint(flag.equals("")?"입력한 정보가 없습니다.":flag);
	}
	
	//4. 이름으로 회원 조회
	public void serchName() {
		String name = view.serchName();
		String flag = dao.serchName(name);
		
		view.resultPrint(flag.equals("")?"입력한 정보가 없습니다.":flag);
	}
}
