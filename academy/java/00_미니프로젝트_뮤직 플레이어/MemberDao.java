package music.play.list.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberDao {
	ArrayList<Member> m = new ArrayList<Member>();	// 전체 회원 리스트
	Member logedMem=null;	// 현재 로그인 중인 객체 정보 저장
	
	public boolean logIn(String id, String password) {
		boolean flag = false;
		
		for(int i=0;i<m.size();i++) {	//id, pw일치 객체 있는 경우 해당 객체 로그인 상태 저장
			if(m.get(i)!=null && m.get(i).getId().equals(id)
					&& m.get(i).getPassword().equals(password)) {
				logedMem=m.get(i);
				return true;
			}
		}
		return flag;
	}
	
	//현재 로그인 상태 확인
	public boolean logedIn() {
		return logedMem!=null;
	}

	public void logOut() {
		this.logedMem=null;
	}
	
	// 중복 ID 체크
	public boolean dupliId(String id) {
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null && m.get(i).getId().equals(id))
					return true;
		}
		return false; 
	}
	
	// 현재 로그인된 회원 정보 확인
	public Member myInfo() {
		return logedMem;
	}
	
	// 회원 정보 수정
	public boolean updateMember(Member mem) {
		boolean flag = false;
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null&&m.get(i).equals(logedMem)) {
				if(mem.getId()!=null) m.get(i).setId(mem.getId());
				if(mem.getPassword()!=null) m.get(i).setPassword(mem.getPassword());
				if(mem.getPhone()!=null) m.get(i).setPhone(mem.getPhone());
				if(mem.getAddress()!=null) m.get(i).setAddress(mem.getAddress());	
				logedMem = m.get(i);
				saveMember();
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	// 회원 가입
	public boolean signUp(Member mem) {
		m.add(mem);
		saveMember();
		return true;
	}

	// 회원 탈퇴	
	public void signOut() {
		m.remove(logedMem);  //회원 목록에서 제거 후 회원 목록 저장
		this.logedMem=null;
		saveMember();
	}
	
	// 프로그램 종료 전, 회원 가입 시 회원 정보 저장
	// 사용자 프로그램이지만 로그인을 위해 DB연동 가정
	public void saveMember() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Member.dat"));){
			oos.writeObject(m);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//회원 정보 불러오기
	public void loadMember() {
		File file = new File("Member.dat");
		if(file.exists()) { //파일이 존재할 경우에 불러오기 실행
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Member.dat"))){
				this.m = (ArrayList<Member>) ois.readObject();
			}catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
