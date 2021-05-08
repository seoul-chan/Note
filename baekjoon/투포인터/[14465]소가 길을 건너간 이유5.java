package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//11728번 - 배열합치기
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input=new StringTokenizer(br.readLine()," ");
		StringBuffer sb=new StringBuffer();
		int size=0,pointer=0;		
		while(input.hasMoreTokens()) {
			size+=Integer.parseInt(input.nextToken());
		}
		
		int[] arr=new int[size];
		
		for(int i=0;i<2;i++) {
			input=new StringTokenizer(br.readLine()," ");
			while(input.hasMoreTokens()) {
				arr[pointer++]=Integer.parseInt(input.nextToken());
			}
		}
		
		Arrays.sort(arr);
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}