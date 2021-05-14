package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int row, col,count=0;
	static char[][] map;	
	
	// 11123번 - 양 한마리... 양 두마리...
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int rotate=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb=new StringBuffer();
		
		while(rotate>0) {
			st=new StringTokenizer(br.readLine()," ");
			row=Integer.parseInt(st.nextToken());
			col=Integer.parseInt(st.nextToken());
			map=new char[row][col];
			
			for(int i=0;i<row;i++) {
				String str=br.readLine();
				for(int j=0;j<col;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(map[i][j]=='#') {
						bfs(i,j);
						count++;						
					}
				}
			}
			sb.append(count).append("\n");
			count=0;
			rotate--;
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> queue=new LinkedList<Node>();
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		queue.offer(new Node(x,y));
		map[x][y]='.';
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=node.x+dx[i];
				int ny=node.y+dy[i];
				
				if(nx>=0&&ny>=0&&nx<row&&ny<col&&map[nx][ny]=='#') {
					queue.offer(new Node(nx,ny));
					map[nx][ny]='.';
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