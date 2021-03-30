package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	//10870번 - 피보나치 수 5
	public static void main(String[] args) throws IOException{
		//0 1 1 2 3 5 8 13 21
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i=Integer.parseInt(br.readLine());
		
		int fibo=fibonacci(i);
		System.out.println(fibo);
		
	}
	public static int fibonacci(int i) {
		if(i==1) return 1;
		if(i==0) return 0;
		
		return fibonacci(i-1)+fibonacci(i-2);
	}
}