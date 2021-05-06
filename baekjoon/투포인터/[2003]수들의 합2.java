package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//2003번 - 수들의 합2
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] input=br.readLine().split(" ");
		int size=Integer.parseInt(input[0]);
		int result=Integer.parseInt(input[1]);
		
		input=br.readLine().split(" ");
		int[] arr=new int[size];
		int sum=0,start=0,end=0,cnt=0;
		
		for(int i=0;i<size;i++) {
			arr[i]=Integer.parseInt(input[i]);
		}
		
		while(start<size) {
			if(sum==result) {
				sum-=arr[start];
				start++;
				cnt++;
			} else if(sum>result||end>=size) {
				sum-=arr[start];
				start++;
			} else {
				sum+=arr[end++];
			}
		}
		System.out.println(cnt);		
	}
}