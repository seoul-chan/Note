package com.algorithm;

import java.util.Scanner;

public class Implements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(), b=sc.nextInt();
		int[][] arr = new int[a][b];
		int x=sc.nextInt(), y=sc.nextInt(), d=sc.nextInt();
		
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		
		
	}
	
	
	
	
	/*
	 
	 	public static void main(String[] args) {
		// 체스판의 주어진 위치에서 이동할 가능한 횟수 출력
		// x축 2칸 y축 1칸 or y축 2칸 x축 1칸 이동 가능
		// x=1~8, y=a~h 범위의 체스판을 가짐
		Scanner sc = new Scanner(System.in);
		
		int[][] move=new int[][] {{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{-1,-2},{1,2},{-1,2}};
		String input = sc.next();
		int x=input.charAt(1)-'0', y=input.charAt(0)-'a'+1;
		
		int count=0;
		
		for(int[] i : move) {
			int row = x+i[0];
			int col = y+i[1];
			
			if(!(row<1||row>8||col<1||col>8)) count++;
		}
		System.out.println(count);
	}
	 
	 // 입력 받은 n시간 까지 3이 포함되는 갯수 출력
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count=0;
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					if((""+i+j+k).contains("3")) count++;
					//if(i%10==3||j/10==0||j%10==3||k/10==0||k%10==3) count++;
				}
			}
		}
		System.out.println(count);
	 
	 public static void main(String[] args) {
		// 입력 받은 n시간 까지 3이 포함되는 갯수 출력
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count=0;
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					if((""+i+j+k).contains("3")) count++;
				}
			}
		}
		System.out.println(count);
	}
	 
	// 동서남북 이동에 따라 최종 좌표를 구하라
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int x=1,y=1;		
		
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		char[] move = {'L','R','U','D'};
		
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
		while(st.hasMoreTokens()) {
			char c = st.nextToken().charAt(0);
			
			int i;
			for(i=0;i<move.length;i++)
				if(c==move[i]) break;
			
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<1||nx>n||ny<1||ny>n) continue;
			x=nx;
			y=ny;
		}
		System.out.println(x+" "+y);
	}
	*/
}
