package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	//10872번 - 팩토리얼
	public static void main(String[] args) throws IOException{
		//5! = 5*4*3*2*1
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i=Integer.parseInt(br.readLine());
		
		long fac=factorial(i);
		System.out.println(fac);
	}
	public static long factorial(int i) {
		if(i<=1) return 1;	//0!이 들어올 수도 있다
		
		return i*factorial(i-1);
	}
}