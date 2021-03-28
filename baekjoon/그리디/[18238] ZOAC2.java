package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//18238번 - ZOAC2
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] input=br.readLine().toCharArray();
		int cur=0, count=0;
		
		for(int i=0;i<input.length;i++) {
			int target=input[i]-'A';	//char->int
			int distance=Math.abs(target-cur);
			
			if(distance>13) //이동거리가 13이상(절반)이면 뒤로 이동
				distance=26-distance;
			
			count+=distance;
			cur=target;
		}
		System.out.println(count);
	}
}