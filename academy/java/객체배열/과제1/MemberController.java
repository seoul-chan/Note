package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	public final int SIZE = 10;
	private Member[] m = new Member[SIZE];
	
	//회원 정보 입력, 테스트 용도 메서드
/*
	public void init() {
		m[0] = new Member("chan1", "chan11", "1234", "chan1@aaa.com", 'M', 21);
		m[1] = new Member("chan2", "chan21", "1234", "chan2@aaa.com", 'F', 26);
		m[2] = new Member("chan3", "chan31", "1234", "chan3@aaa.com", 'M', 29);
		m[3] = new Member("chan4", "chan41", "1234", "chan4@aaa.com", 'F', 30);
		m[4] = new Member("chan5", "chan51", "1234", "chan5@aaa.com", 'M', 36);
		m[5] = new Member("chan6", "chan61", "1234", "chan6@aaa.com", 'F', 27);
		m[6] = new Member("chan7", "chan71", "1234", "chan7@aaa.com", 'M', 40);
		m[7] = new Member("chan8", "chan81", "1234", "chan8@aaa.com", 'F', 57);
		m[8] = new Member("chan9", "chan91", "1234", "chan9@aaa.com", 'M', 42);
	}
*/	
	public int existMemberNum() {
		int count=0;
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) count++;
		}
		return count;
	}
	
	public boolean checkId(String inputId) {
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getId().equals(inputId)) return false;
		}
		return true;
	}
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		for(int i=0;i<m.length;i++) {
			if(m[i]==null) {
				m[i] = new Member(id, name, password, email, gender, age);
				break;
			}
		}
	}
	
	public String searchId(String id) {
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getId().equals(id)) {
				return m[i].inform();
			}
		}
		return "";
	}
	
	public Member[] searchName(String name) {
		int count=0;
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getName().equals(name)) {
				count++;
			}
		}
		
		if(count==0) return null;
		Member[] search = new Member[count];
		count=0;
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getName().equals(name)) {
				search[count++]=m[i];
			}
		}
		return search;
	}
	
	public Member[] searchEmail(String email) {
		int count=0;
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getEmail().equals(email)) {
				count++;
			}
		}
		
		if(count==0) return null;
		Member[] search = new Member[count];
		count=0;
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getEmail().equals(email)) {
				search[count++]=m[i];
			}
		}
		return search;
	}
	
	public boolean updatePassword(String id, String password) {
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getId().equals(id)) {
				m[i].setPassword(password);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateName(String id, String name) {
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getId().equals(id)) {
				m[i].setName(name);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateEmail(String id, String email) {
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getId().equals(id)) {
				m[i].setEmail(email);
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(String id) {
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getId().equals(id)) {
				m[i]=null;
				return true;
			}
		}
		
		return false;
	}
	
	public void delete() {
		for(int i=0;i<m.length;i++) {
			m[i]=null;
		}
	}
	
	public Member[] printAll() {
		int count = 0;
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) count++;
		}
		
		return (count!=0)?m:null;
	}
}
