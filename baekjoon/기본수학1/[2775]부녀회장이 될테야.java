package com.test;

import java.util.Scanner;

public class Main {
	//2775¹ø
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();	//È½¼ö

		int[][] arr=new int[15][15];
		for(int i=1;i<15;i++) {	//°¢ Ãþ 1È£, 0Ãþ ÃÊ±âÈ­
			arr[i][1]=1;
			arr[0][i]=i;
		}
		
		for(int i=1;i<15;i++) { //¸ðµç È£¼ö ÃÊ±âÈ­
			for(int j=1;j<15;j++) {
				arr[i][j]=arr[i][j-1]+arr[i-1][j];
			}
		}
		
		for(int i=0;i<t;i++) {
			int k=sc.nextInt();	//Ãþ¼ö
			int n=sc.nextInt();	//È£¼ö
			System.out.println(arr[k][n]);
		}
	}	
}