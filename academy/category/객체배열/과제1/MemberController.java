package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	public final int SIZE = 10;
	private Member[] m = new Member[SIZE];
	
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
				m[i] = new Member();
				m[i].setId(id);
				m[i].setName(name);
				m[i].setPassword(password);
				m[i].setEmail(email);
				m[i].setGender(gender);
				m[i].setAge(age);
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
		
		return m;
	}
	
	public Member[] searchEmail(String email) {
		
		return m;
	}
	
	public boolean updatePassword(String id, String password) {
		
		return true;
	}
	
	public boolean updateName(String id, String name) {
		
		return true;
	}
	
	public boolean updateEmail(String id, String email) {
		
		return true;
	}
	
	public boolean delete(String id) {
		
		return true;
	}
	
	public void delete() {
		
	}
	
	public Member[] printAll() {
		
		return m;
	}
}
