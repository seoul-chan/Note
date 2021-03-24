package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	//15552¹ø - ºü¸¥ A+B
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cycle;
		try {
			cycle = Integer.valueOf(br.readLine());
			for(int i=0;i<cycle;i++) {
				st = new StringTokenizer(br.readLine()," ");
				sb.append(Integer.valueOf(st.nextToken())+Integer.valueOf(st.nextToken())+"\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}