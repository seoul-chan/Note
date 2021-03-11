package music.play.list.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberDao {
	ArrayList<Member> m = new ArrayList<Member>();
	//HashMap<String, String> h =new HashMap<String, String>();
	
	Member logedMem=null;
	
	public boolean logIn(String id, String password) {
		boolean flag = false;
		
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null && m.get(i).getId().equals(id)
					&& m.get(i).getPassword().equals(password)) {
				logedMem=m.get(i);
				return true;
			}
		}
		return flag;
	}

	public void logOut() {
		this.logedMem=null;
	}
	
	public boolean dupliId(String id) {
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null && m.get(i).getId().equals(id))
					return true;
		}
		return false; 
	}
	
	public Member myInfo() {
		return logedMem;
	}
	
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
	
	public boolean signUp(Member mem) {
		boolean flag = false;
		
//		for(int i=0;i<=m.size();i++) {
//			if(m.get(i)==null) {
				m.add(mem);
				flag=true;
				saveMember();
//				break;
//			}	
//		}
		return flag;
	}
	
	public void signOut() {
		m.remove(logedMem);
		this.logedMem=null;
		saveMember();
	}
	
	// 프로그램 종료 전 회원 정보 저장
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
