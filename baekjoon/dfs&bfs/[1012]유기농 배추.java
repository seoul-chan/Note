package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int row;
	static int col;
	static int count=0;
	
	//1012번 - 유기농 배추
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		int t=Integer.parseInt(br.readLine());			//테스트 케이스
		
		while(t!=0) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			col=Integer.parseInt(st.nextToken());		//가로
			row=Integer.parseInt(st.nextToken());;		//세로
			int point=Integer.parseInt(st.nextToken());;	//배추 개수
			map=new int[row][col];
			visited=new boolean[row][col];
			
			for(int i=0;i<point;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int c=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				map[r][c]=1;
			}
			
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(!visited[i][j]&&map[i][j]==1) {
						check(i,j);
						count++;						
					}
				}
			}
			sb.append(count).append("\n");
			count=0;
			t--;
		}
		System.out.println(sb);
	}
	
	public static void check(int x, int y) {
		visited[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(isAvailable(nx, ny)) {
				check(nx,ny);
			}
		}
	}
	
	public static boolean isAvailable(int x,int y) {
		if(x<0||x>=row||y<0||y>=col) return false;
		if(visited[x][y]||map[x][y]!=1) return false;
		return true;
	}
}