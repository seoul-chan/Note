package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {}
	
	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str.toUpperCase(), " ");
		
		str="";
		while(st.hasMoreTokens()) str+=st.nextToken();
		
		return str;
	}
	
	public String firstCap(String input) {
		char temp[] = input.toCharArray();
		temp[0] = Character.toUpperCase(temp[0]);
		
		return new String(temp);
	}
	
	public int findChar(String input, char one) {
		int count=0;
		
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)==one) count++;
		}
		return count;
	}
}
