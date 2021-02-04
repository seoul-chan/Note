package com.member.model.dao;

import com.member.model.vo.Member;

public class MemberDao {
	private Member[] m=new Member[5];
	
	//1. 전체회원 조회
	public String serchAll() {
		String mem = "";
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) {mem+=m[i].serchAll();}
		}
		return mem;
	}
	
	//2. 회원 등록
	public boolean insertMember(Member mem) {
		boolean flag = false;
		for(int i=0;i<m.length;i++) {
			if(m[i]==null) {
				m[i]=mem;
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	//3. 아이디로 회원 조회
	public String serchId(String id) {
		String mem ="";
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getId().equals(id)) {mem+=m[i].serchAll();}
		}
		return mem;
	}
	
	//4. 이름으로 회원 조회
	public String serchName(String name) {
		String mem ="";
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getName().equals(name)) {mem+=m[i].serchAll();}
		}
		return mem;
	}
	
	//5. 회원 정보 수정
	public boolean updateMember(Member mem) {
		boolean flag = false;
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getName().equals(mem.getName())) {
				if(mem.getAge()!=0) m[i].setAge(mem.getAge());
				if(mem.getGender()!='\u0000')m[i].setGender(mem.getGender());
				if(mem.getAddress()!=null)m[i].setAddress(mem.getAddress());
				if(mem.getId()!=null)m[i].setId(mem.getId());
				if(mem.getPw()!=0)m[i].setPw(mem.getPw());
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	//6. 회원 정보 제거
	public boolean removeMember(Member mem) {
		boolean flag = false;
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null&&m[i].getMemberNo()==mem.getMemberNo()&&m[i].getName().equals(mem.getName())) {
				m[i]=null;
				flag=true;
				break;
			}
		}
		return flag;
	}
}
