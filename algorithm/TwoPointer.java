package com.algorithm;

public class TwoPointer {
	public static void main(String[] args){
		int[] arr= {2,4,2,1,5};
		int cnt=0;	// 목표 값의 갯수
		int start=0, end=0, sum=0;	// 시작점, 끝점, 합계
		int result=6;	// 목표 값
		
		while(start!=arr.length) {
			if(sum==result) {	//1. 합계와 목표값이 같은 경우 시작점, 갯수 증가
				sum-=arr[start];
				start++;
				cnt++;
			} else if(sum>result||end>=arr.length) {	//2. 합계가 목표값보다 크거나 끝점이 배열 길이를 넘은경우
				sum-=arr[start];
				start++;				
			} else {	//3. 합계가 목표값보다 적은경우
				sum+=arr[end++];
			}
		}
		System.out.println(cnt);
	}
}
