package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//18238번 - ZOAC2
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cur1=0,cur2=25,count=0;
		String str="",rStr="";
		
		for(int i=0;i<26;i++)	//A-Z 
			str+=(char) (65+i);
		
		for(int i=0;i<26;i++)	//Z-A
			rStr+=(char) (90-i);
		
		String input=br.readLine();
		for(int i=0;i<input.length();i++) {
			String find=input.substring(i, i+1);
			int point1=str.indexOf(find);	//A-Z에서 알파벳 위치
			int point2=rStr.indexOf(find);	//Z-A에서 알파벳 위치
			
			int count1=(point1>=cur1)?point1-cur1:str.length()-(cur1-point1);
			cur1=point1; //A-Z에서 현재 위치 저장
			
			int count2=(point2>=cur2)?point2-cur2:rStr.length()-(cur2-point2);
			cur2=point2; //Z-A에서 현재 위치 저장
			
			if(count1<count2) count+=count1;
			else count+=count2;
		}
		System.out.println(count);
	}
}