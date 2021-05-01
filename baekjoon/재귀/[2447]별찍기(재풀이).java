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
		
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public static void star(int row, int col, int n, boolean blank) {

		if(blank) {
			for(int i=row;i<row+n;i++) {
				for(int j=col;j<col+n;j++) {
					arr[i][j]=' ';
				}
			}
			return;
		}

		if(n==1) {
			arr[row][col]='*';
			return;
		}

		int size=n/3;
		int count=0;
		for(int i=row;i<row+n;i+=size) {
			for(int j=col;j<col+n;j+=size) {
				count++;
				if(count==5)
					star(i,j,size,true);
				else
					star(i,j,size,false);
			}
		}
	}
}