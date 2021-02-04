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
		view.memberList(search.equals("")?"입력한 정보가 없습니다.":search);
	}
	
	//2. 회원 등록
	public void insertMember() {
		Member mem = view.insetMember();
		boolean flag = dao.insertMember(mem);
		view.resultPrint(flag?"회원 등록이 성공하였습니다.":"더 이상 회원을 등록할 수 없습니다.");
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
	//5. 회원 정보 수정
	public void updateMember() {
		Member mem = view.updateMember();
		boolean flag = dao.updateMember(mem);
		view.resultPrint(flag?"회원 정보가 수정되었습니다.":"입력하신 회원을 찾을 수 없습니다.");
	}
	
	//6. 회원 정보 제거
		public void removeMember() {
			Member mem = view.removeMember();
			boolean flag = dao.removeMember(mem);
			view.resultPrint(flag?"회원 정보가 제거되었습니다.":"입력하신 회원을 찾을 수 없습니다.");
		}
}
