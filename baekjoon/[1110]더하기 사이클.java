package com.test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		int cycle=0,sum=input;
		
		while(true) {
			//(sum%10)*10 : 이전 값의 두 정수중 두번째 정수
			//((sum/10)+(sum%10))%10 : 이전 합계의 1의 자리
			sum=(sum%10)*10 + ((sum/10)+(sum%10))%10;
			cycle++;
			if(sum==input) break;
		}
		System.out.println(cycle);
	}	
}

/*
public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		int a=input/10,b=input%10,cycle=0;
		int sum,temp;
		
		while(true) {
			temp=a+b;
			a=b;
			b=temp%10;
			sum=a*10+b;
			cycle++;
			if(sum==input) break;
		}
		System.out.println(cycle);
	}	
}
*/