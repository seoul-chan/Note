package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {	
	
	// 20922번 - 겹치는 건 싫어
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] arr=new int[n+1];
		int[] count=new int[n+1];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<n+1;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int start=1,end=1, distance=0, max=0;
		System.out.println("k : "+k);
		while(start<n) {
			if(end>n||count[arr[end]]>=k) {
				count[arr[start]]--;
				System.out.println("start : "+start);
				start++;
			} else if(count[arr[end]]<k) {
				count[arr[end]]++;
				System.out.println("end : "+end);
				end++;		
			}
			distance=end-start;
			max=Math.max(max, distance);
		}
		System.out.println(max);
	}
}