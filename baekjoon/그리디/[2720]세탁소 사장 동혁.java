package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//2720번 - 세탁소 사장 동혁
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		int input=Integer.parseInt(br.readLine());
		int[] change=new int[] {25,10,5,1};
		
		for(int i=0;i<input;i++) {
			int cent=Integer.parseInt(br.readLine());
			for(int j=0;j<change.length;j++) {
				sb.append(cent/change[j]).append(" ");
				cent%=change[j];
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}