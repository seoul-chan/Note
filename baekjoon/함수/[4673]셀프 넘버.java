package com.test;

public class Main {
	// 4673번 - 셀프 넘버
	public static void main(String[] args){
		boolean[] check = new boolean[10001];
		
		for(int i=1;i<10001;i++) {
			int n=d(i);	// 함수에서 반환된 값은 셀프넘버 X
			if(n<=10000)
				check[n]=true;	// 셀프넘버가 아닌 값을 체크
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<10001;i++) {
			if(check[i]==false)
				sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int d(int number) {
		int sum=number;
		
		while(number!=0) {
			sum+=number%10;	// 끝 자리부터 더함
			number/=10;	// /10을 하여 하나씩 자릿수를 줄여나감
		}
		return sum;
	}
}