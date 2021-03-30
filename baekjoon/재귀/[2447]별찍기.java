package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
	//2447번 - 별찍기
	static char[][]arr;
			
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		arr =new char[N][N];
		
		star(0,0,N,false);
		
		// BufferedWriter의 wtite메소드는 배열도 순서대로 출력
		// 2차원 배열은 한 행씩 write해주면 행의 열들을 순서대로 출력한다.
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public static void star(int x, int y, int N, boolean blank) {
		// 공백일 경우
		if(blank) {
			for(int i=x;i<x+N;i++) {
				for(int j=y;j<y+N;j++) {
					arr[i][j]=' ';
				}
			}
			return;
		}
		
		// 더 이상 쪼갤 수 없는 블록일 때
		if(N==1) {
			arr[x][y]='*';
			return;
		}
		
		// size : N의 블록에서 한 블록의 크기
		// N:27에서 한블록의 크기는 size:9가 된다.
		// count : 한 블록에서 5번째가 되는 블록은 공백으로 채우기 위한 카운터 변수
		int size=N/3;
		int count=0;
		for(int i=x;i<x+N;i+=size) {
			for(int j=y;j<y+N;j+=size) {
				count++;
				if(count==5)	//5번째 블록은 공백으로 채우기 위해
					star(i,j,size,true);
				else
					star(i,j,size,false);
			}
		}
	}
}