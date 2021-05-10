package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	//2018번 - 수들의 합 5
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int start=1,end=1,sum=0,cnt=0;
		
		while(start<=N) {
			if(sum==N) {
				sum-=start;
				start++;
				cnt++;
			}else if(sum>N||end>N) {
				sum-=start;
				start++;
			}else {
				sum+=end;
				end++;
			}
		}
		System.out.println(cnt);
	}
}