package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 10870번 - 피보나치 수 5
	public static void main(String[] args) throws IOException{
		BufferedReader sb=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(sb.readLine());
		System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int i) {
		if(i<=0)
			return 0;
		else if(i==1)
			return 1;
		
		return fibonacci(i-2)+fibonacci(i-1);
	}
}