package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String,Member>();
	
	public boolean joinMembership(String id, Member m) {
		if(!(map.containsKey(id))) {
			map.put(id, m);
			return true;
		}
		else 
			return false;
	}
	
	public String login(String id, String password) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(password))
			return map.get(id).getName();			
		
		return "";
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(oldPw)) {
			map.get(id).setPassword(newPw);
			return true;
		} else 
			return false;
	}
	
	public void changeName(String id, String newName) {
		map.get(id).setName(newName);
	}
	
	public TreeMap sameName(String name) {
		TreeMap tm = new TreeMap();
		
		for(int i=0;i<map.size();i++) {
			Set keys = map.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String id = it.next();
				if(map.get(id).getName().equals(name))
					tm.put(id, name);
			}
		}
		return tm;
	}
}
