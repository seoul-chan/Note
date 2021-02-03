package com.member.model.dao;

import com.member.model.vo.Member;

public class MemberDao {
	private Member m1;
	private Member m2;
	private Member m3;
	private Member m4;
	private Member m5;
	
	//1. 전체회원 조회
	public String serchAll() {
		String mem = "";

		if(m1!=null) {mem+=m1.serchAll();}
		if(m2!=null) {mem+=m2.serchAll();}
		if(m3!=null) {mem+=m3.serchAll();}
		if(m4!=null) {mem+=m4.serchAll();}
		if(m5!=null) {mem+=m5.serchAll();}
		
		return mem;
	}
	
	//2. 회원 등록
	public boolean insertMember(Member mem) {
		boolean flag = true;
		if(m1==null) {m1=mem;}
		else if (m2==null) {m2=mem;}
		else if (m3==null) {m3=mem;}
		else if (m4==null) {m4=mem;}
		else if (m5==null) {m5=mem;}
		else {
			flag = false;
		}
		return flag;
	}
	
	//3. 아이디로 회원 조회
	public String serchId(String id) {
		String mem ="";
		if(m1!=null&&m1.getId().equals(id)) {mem+=m1.serchAll();}
		if(m2!=null&&m2.getId().equals(id)) {mem+=m2.serchAll();}
		if(m3!=null&&m3.getId().equals(id)) {mem+=m3.serchAll();}
		if(m4!=null&&m4.getId().equals(id)) {mem+=m4.serchAll();}
		if(m5!=null&&m5.getId().equals(id)) {mem+=m5.serchAll();}
		return mem;
	}
	
	//4. 이름으로 회원 조회
	public String serchName(String name) {
		String mem ="";
		if(m1!=null&&m1.getName().equals(name)) {mem+=m1.serchAll();}
		if(m2!=null&&m2.getName().equals(name)) {mem+=m2.serchAll();}
		if(m3!=null&&m3.getName().equals(name)) {mem+=m3.serchAll();}
		if(m4!=null&&m4.getName().equals(name)) {mem+=m4.serchAll();}
		if(m5!=null&&m5.getName().equals(name)) {mem+=m5.serchAll();}
		return mem;
	}
}
