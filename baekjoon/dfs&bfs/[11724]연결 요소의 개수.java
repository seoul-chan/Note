package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	static int node,edge;
	static int[][] map;
	static boolean[] visited;
	
	// 11724번 - 연결 요소의 개수
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] input=br.readLine().split(" ");
		node=Integer.parseInt(input[0]);
		edge=Integer.parseInt(input[1]);
		map=new int[node+1][node+1];
		visited=new boolean[node+1];
		
		for(int i=0;i<edge;i++) {
			input=br.readLine().split(" ");
			int start=Integer.parseInt(input[0]);
			int end=Integer.parseInt(input[1]);
			
			map[start][end]=1;
			map[end][start]=1;
			visited[start]=true;
			visited[end]=true;
		}

		// 간선이 연결되지 않은 단일 노드도 연결 요소로 포함해야 하기에
		int cnt=0;
		for(int i=1;i<node+1;i++) {
			if(visited[i]==false) cnt++;
		}
		
		visited=new boolean[node+1];
		for(int i=1;i<node+1;i++) {
			for(int j=1;j<node+1;j++) {
				if(map[i][j]==1&&visited[i]==false) {
					dfs(i);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		visited[start]=true;
		
		for(int i=1;i<node+1;i++) {
			if(map[start][i]==1&&visited[i]==false)
				dfs(i);
		}
	}
}