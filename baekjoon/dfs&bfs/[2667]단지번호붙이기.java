package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int n;
	static int sum=0;
	
	//2667번 - 단지번호붙이기
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		visited=new boolean[n][n];
		int count=0;
		
		for(int i=0;i<n;i++) {
			String[] str=br.readLine().split("");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					dfs(i,j);
					count++;
					list.add(sum);
					sum=0;
				}
			}
		}
		Collections.sort(list);
		sb.append(count+"\n");
		for(int i=0;i<list.size();i++)
			sb.append(list.get(i)+"\n");
		
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		if(x<0||y<0||x>=n||y>=n||map[x][y]==0||visited[x][y]==true) return;
		visited[x][y]=true;
		
		if(map[x][y]==1) sum+=1;
		
		dfs(x-1,y);
		dfs(x+1,y);
		dfs(x,y-1);
		dfs(x,y+1);
	}
}