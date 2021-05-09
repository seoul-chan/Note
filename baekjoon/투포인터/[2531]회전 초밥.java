package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	//2531번 - 회전 초밥
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,d,k,c;
	static int[] arr, eated;
	
	public static void main(String[] args) throws IOException{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());	// 접시 갯수
		d=Integer.parseInt(st.nextToken());	// 초밥 갯수
		k=Integer.parseInt(st.nextToken());	// 연속 수
		c=Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		arr=new int[N];	// 접시 갯수 만큼 생성
		eated=new int[d+1];	// index 1부터 사용하기 위해 초밥 갯수+1 만큼 생성
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(rotate());
	}
	
	public static int rotate() {
		int count=0,max=0;
		
		// 처음 연속 수 카운트
		for(int i=0;i<k;i++) {
			if(eated[arr[i]]==0) count++;			
			eated[arr[i]]++;
		}
		
		// 쿠폰이 포함된 초밥이 없는 경우 count증가 
		if(eated[c]==0) count++;
		eated[c]++;			
		max=count;
		
		for(int i=1;i<N;i++) {			
			//window start 지점
			eated[arr[i-1]]--;
			if(eated[arr[i-1]]==0) count--;
			
			//window end 지점
			eated[arr[(i+k-1)%N]]++;
			if(eated[arr[(i+k-1)%N]]==1) count++;
			
			if(max<count) max=count;
		}
		return max;
	}
}