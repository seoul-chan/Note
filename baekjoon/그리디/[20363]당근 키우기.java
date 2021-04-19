package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	// 20363번 - 당근 키우기	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] xy=br.readLine().split(" ");
		int x=Integer.parseInt(xy[0]);	//온기
		int y=Integer.parseInt(xy[1]);	//수분
		int sum=x+y+Math.min(x, y)/10;
		
		System.out.println(sum);
	}
}