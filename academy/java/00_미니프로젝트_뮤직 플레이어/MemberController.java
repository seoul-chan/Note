package music.play.list.controller;

import music.play.list.model.Member;
import music.play.list.model.MemberDao;

public class MemberController {
	MemberDao md = new MemberDao();
	
	public boolean logIn(String id, String password) {
		return md.logIn(id, password);
	}
	
	public void logOut() {
		md.logOut();
	}
	
	public boolean dupliId(String id) {
		return md.dupliId(id);
	}
	
	public Member myInfo() {
		return md.myInfo();
	}
	
	public boolean updateMember(Member m) {
		return md.updateMember(m);
	}
	
	public boolean signUp(Member m) {
		return md.signUp(m);
	}
	
	public void signOut() {
		md.signOut();
	}
	
	public void loadMember() {
		md.loadMember();
	}
	
	public void saveMember() {
		md.saveMember();
	}
	
	
}
