package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//2577번 - 숫자의 개수
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());
		int c=Integer.parseInt(br.readLine());
		int count=0;
		String sum = String.valueOf((a*b*c));
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<sum.length();j++) {
				if((Integer.valueOf(sum.charAt(j))-'0')==i) count++;
			}
			System.out.println(count);
			count=0;
		}
	} // main
}