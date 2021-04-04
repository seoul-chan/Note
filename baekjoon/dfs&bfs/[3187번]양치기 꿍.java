package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] visited;
	static String[][] map;
	static int vCount=0;
	static int kCount=0;
	
	//3187번 - 양치기 꿍
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int row=Integer.parseInt(str[0]);
		int col=Integer.parseInt(str[1]);
		map=new String[row][col];
		visited=new boolean[row][col];
		int v=0;	//늑대
		int k=0;	//양
		
		for(int i=0;i<row;i++) {
			str=br.readLine().split("");
			for(int j=0;j<col;j++) {
				map[i][j]=str[j];
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(!visited[i][j]) {
					dfs(i,j);	
					
					if(kCount>vCount) k+=kCount;
					else v+=vCount;
					
					kCount=0;
					vCount=0;					
				}
			}
		}
		System.out.println(k+" "+v);
	}
	
	public static void dfs(int x,int y) {
		if(x<0||x>=map.length||y<0||y>=map[x].length||map[x][y].equals("#")||visited[x][y]) return; 
		visited[x][y]=true;
				
		if(map[x][y].equals("v")) vCount++;
		else if(map[x][y].equals("k")) kCount++;
			
		dfs(x-1,y);
		dfs(x+1,y);
		dfs(x,y-1);
		dfs(x,y+1);	
	}
}