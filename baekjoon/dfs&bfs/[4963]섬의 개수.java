package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {	
	static int width,height,count=0;
	static int[][] map;
	
	
	// 4963번 - 섬의 개수
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		
		while(true) {
			st=new StringTokenizer(br.readLine()," ");
			width=Integer.parseInt(st.nextToken());
			height=Integer.parseInt(st.nextToken());
			
			if(width==0&&height==0) break;
			
			map=new int[height][width];
			
			for(int i=0;i<height;i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<width;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(map[i][j]==1) {
						bfs(i,j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
			count=0;						
		}
		System.out.println(sb);
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q=new LinkedList<int[]>();
		int[] dx= {-1,-1,0,1,1,1,0,-1};
		int[] dy= {0,-1,-1,-1,0,1,1,1};
		q.offer(new int[]{x,y});
		map[x][y]=0;
		
		while(!q.isEmpty()) {
			int[] arr=q.poll();
			
			for(int i=0;i<8;i++) {
				int nx=arr[0]+dx[i];
				int ny=arr[1]+dy[i];
				
				if(nx<0||ny<0||nx>=map.length||ny>=map[nx].length||map[nx][ny]==0) continue;
				q.offer(new int[] {nx,ny});
				map[nx][ny]=0;
			}
		}
	}
 }