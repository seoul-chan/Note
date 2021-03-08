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

	public void updateMember() {
		
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
