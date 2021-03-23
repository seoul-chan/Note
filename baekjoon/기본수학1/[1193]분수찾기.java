package com.test;

import java.util.Scanner;

public class Main {
	//1193번
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();	// 몇 번째 값
		int prev_sum=0, cur=1;	// 이전 원소 개수의 합, 현재 원소 개수
		while(true) {
			if(x<=prev_sum+cur) {	//이전,현재 원소 개수가 입력 값보다 큰 경우
				if(cur%2==1) {
					System.out.println((cur+1-(x-prev_sum))+"/"+(x-prev_sum));
					break;
				}else {
					System.out.println((x-prev_sum)+"/"+(cur+1-(x-prev_sum)));
					break;
				}
			}else {	//이전,현재 원소 개수가 입력 값보다 작은 경우
				prev_sum+=cur;	// 이전 원소 합 + 현재 원소 개수
				cur++;	// 현재 원소 개수 증가
			}
		}
	}	
}