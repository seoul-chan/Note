package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy {
	public static void main(String[] args) {
		/*
		 * 큰 수의 법칙
		 * n : 배열의 크기
		 * m : 숫자가 더해지는 총 횟수
		 * k : 큰 숫자가 더해지는 횟수
		 * 배열의 크기만큼 숫자가 주어지고 숫자 중 제일 큰 숫자를 m번만큼 더해준다.
		 * 단, 한번에 더할수 있는 횟수는 k번이며
		 * k번만큼 더했을 경우 두 번째 큰 숫자를 더한 후 다시 제일 큰 숫자를 더할수 있다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt();	
		int[] arr=new int[n];
		int sum=0;
		
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);		
		for(int i=0;i<m;i++) {
			for(int j=0;j<k;j++) {
				sum+=arr[n-1];
				i++;
			}
			sum+=arr[n-2];
		}
		System.out.println(sum);
	}
	
	
	/*
	
	
	
	public static void main(String[] args) {
		// 동전 거슬러 주기
		int n = 1260;	//거스름돈
		int count=0;
		
		int[] coint_type = new int[] {500,100,50,10};
		for(int i : coint_type) {
			count=count+(n/i);
			n%=i;
		}
		System.out.println(count);
	}
	
	*/
}
