package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int node;
	static int edge;
	static int[][]map;
	static boolean[]visited;
	static StringBuilder sb=new StringBuilder();
	
	//1260번 - DFS와 BFS
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		node=Integer.parseInt(s[0]);
		edge=Integer.parseInt(s[1]);
		map=new int[node+1][node+1];
		visited=new boolean[node+1];
		int start=Integer.parseInt(s[2]);
		
		for(int i=0;i<edge;i++) {
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			
			map[x][y]=map[y][x]=1;
		}
		dfs(start);
		clear();
		bfs(start);
		System.out.println(sb);
		
	}
	public static void dfs(int start) {
		visited[start]=true;
		sb.append(start+" ");
		
		for(int i=1;i<node+1;i++) {
			if(map[start][i]==1&&visited[i]==false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			sb.append(temp+" ");
			
			for(int i=1;i<node+1;i++) {
				if(map[temp][i]==1&&visited[i]==false) {
					q.offer(i);
					visited[i]=true;
				}
			}
		}
	}
	
	public static void clear() {
		for(int i=0;i<node+1;i++) {
			visited[i]=false;
		}
		sb.append("\n");
	}
}