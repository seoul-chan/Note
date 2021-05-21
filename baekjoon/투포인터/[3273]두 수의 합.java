package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	
	// 3273번 - 두 수의 합
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int target=Integer.parseInt(br.readLine());
		
		int[] arr=new int[n];
		int start=0,end=n-1,answer=0;
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		while(start!=end) {
			if(start>end) break;
			
			if(target==(arr[start]+arr[end])) {
				start++;
				end--;
				answer++;
			}else if(target>(arr[start]+arr[end])) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(answer);		
	}
}