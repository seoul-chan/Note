package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int row,col,sCount=0, wCount=0;
	static String[][] map;
	
	// 3814번 - 양
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		map=new String[row][col];
		
		for(int i=0;i<row;i++) {
			String[] str=br.readLine().split("");
			for(int j=0;j<col;j++) {
				map[i][j]=str[j];
			}
		}
		
		int sheep=0,woolf=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(!map[i][j].equals("#")) {
					dfs(i,j);
					if(sCount>wCount) sheep+=sCount;
					else woolf+=wCount;
					
					sCount=0;
					wCount=0;					
				}
			}
		}
		System.out.println(sheep+" "+woolf);
	}
	
	public static void dfs(int x, int y) {
		if(x<0||x>=map.length||y<0||y>=map[x].length||map[x][y].equals("#")) return;
		if(map[x][y].equals("o")) sCount++;
		if(map[x][y].equals("v")) wCount++;
		map[x][y]="#";
		
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			dfs(nx,ny);
		}
	}
 }