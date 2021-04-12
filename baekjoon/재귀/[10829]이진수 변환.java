package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	// 10829번 - 이진수 변환
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long n=Long.parseLong(br.readLine());
		
		binary(n);
		System.out.println(sb);
	}
	
	public static void binary(long decimal) {
		if(decimal==1) {
			sb.insert(0,1);
			return;
		}
		sb.insert(0, decimal%2);
		binary(decimal/2);
	}
}