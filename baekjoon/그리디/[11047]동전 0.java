package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	//11047번 - 동전 0
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]); //동전 개수
		int money=Integer.parseInt(str[1]); //목표 금액
		int[] coin=new int[n];
		int count=0;
		
		for(int i=0;i<n;i++) 
			coin[i]=Integer.parseInt(br.readLine()); //동전 가치
		
		for(int i=n-1;i>=0;i--) {
			count+=money/coin[i];
			money%=coin[i];			
		}
		System.out.println(count);
	}
}