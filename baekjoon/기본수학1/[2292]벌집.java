package com.test;

import java.util.Scanner;

public class Main {
	//2292번 벌집
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();	// 몇 번째 값
		int count=1, sum=1;	//증가값, 이전값 합
		while(n>sum) {		// 이전 값 합보다 n이 작으면 반복문 중지
			sum+=6*count;	//6배수씩 증가 후 이전값 합
			count++;
		}
		System.out.println(count);
	}	
}