package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] visited;
	
	//16948번 - 데스 나이트
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		visited=new boolean[n][n];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int r1=Integer.parseInt(st.nextToken());
		int c1=Integer.parseInt(st.nextToken());
		int r2=Integer.parseInt(st.nextToken());
		int c2=Integer.parseInt(st.nextToken());
		
		int result=bfs(r1, c1, r2, c2);
		System.out.println(result);
	}
	
	public static int bfs(int r1, int c1,int r2,int c2) {
		Queue<Node> q=new LinkedList<Node>();
		int[] dx= {-2,-2,0,0,2,2};	//이동 범위
		int[] dy= {-1,1,-2,2,-1,1};
		
		q.offer(new Node(r1,c1,0));
		
		while(!q.isEmpty()) {
			Node node=q.poll();
			
			if(node.row==r2&&node.col==c2)	//이동 위치와 목표 위치가 같은 경우 리턴
				return node.move;
			
			for(int i=0;i<6;i++) {
				int nx=node.row+dx[i];
				int ny=node.col+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny]==true) continue;
				
				q.offer(new Node(nx,ny,node.move+1));	//이동 횟수 증가 후 추가
				visited[nx][ny]=true;
			}
		}
		return -1;
	}
}

class Node{
	int row;
	int col;
	int move;
	
	Node(int row,int col,int move){
		this.row=row;
		this.col=col;
		this.move=move;
	}
}