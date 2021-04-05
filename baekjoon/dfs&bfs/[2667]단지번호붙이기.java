package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int n;
	static int sum=0;
	static ArrayList<Integer> list;
	
	//2667번 - 단지번호붙이기
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		list=new ArrayList<Integer>();
		
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		int count=0;
		
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					bfs(i,j);
					count++;
					sum=0;
				}
			}
		}
		Collections.sort(list);
		sb.append(count).append("\n");
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x,int y) {
		Queue<Node> q=new LinkedList<Node>();
		int[] dx={-1,1,0,0};
		int[] dy= {0,0,-1,1};
		sum+=1;
		map[x][y]=0;
				
		q.offer(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node node=q.poll();
			
			for(int i=0;i<4;i++) {
				int nx=node.x+dx[i];
				int ny=node.y+dy[i];
				
				if(nx>=0&&nx<n&&ny>=0&&ny<n) {
					if(map[nx][ny]==1) {
						q.offer(new Node(nx,ny));
						map[nx][ny]=0;
						sum+=1;
					}
				}
			}	
		}
		list.add(sum);
	}
}
class Node{
	int x;
	int y;
	
	Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}