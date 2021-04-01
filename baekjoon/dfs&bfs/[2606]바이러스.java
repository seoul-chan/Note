package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int node;
	static int edge;
	static int[][]map;
	static boolean[]visited;
	static int count=0;
	
	//2606번 - 바이러스
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		node=Integer.parseInt(br.readLine());
		edge=Integer.parseInt(br.readLine());
		map=new int[node+1][node+1];
		visited=new boolean[node+1];

		for(int i=0;i<edge;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			map[x][y]=1;
			map[y][x]=1;
		}
		dfs(1);
		System.out.println(count);
	}
	public static void dfs(int x) {
		visited[x]=true;
		
		for(int i=1;i<node+1;i++) {
			if(map[x][i]==1&&visited[i]==false) {
				count++;
				dfs(i);
			}
		}
	}
}