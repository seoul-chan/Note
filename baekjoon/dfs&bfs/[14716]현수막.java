package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int row,col,count=0;
	static int[][] map;
	
	// 14716번 - 현수막
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		map=new int[row][col];
		
		for(int i=0;i<row;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<col;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(map[i][j]==1) {
					bfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(new Node(x,y));
		int[] dx= {-1,-1,0,1,1,1,0,-1};
		int[] dy= {0,-1,-1,-1,0,1,1,1};		
		map[x][y]=0;
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			for(int i=0;i<8;i++) {
				int nx=node.x+dx[i];
				int ny=node.y+dy[i];
				
				if(nx>=0&&ny>=0&&nx<row&&ny<col&&map[nx][ny]==1) {
					queue.offer(new Node(nx,ny));
					map[nx][ny]=0;
				}
			}
		}
	}
 }

class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}