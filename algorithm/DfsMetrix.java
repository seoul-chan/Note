package com.algorithm;

import java.util.Scanner;

public class DfsMetrix {

	static int edge;	//노드간 연결하는 간선의 수
	static int vertex;	//노드(데이터)의 개수
	static int[][] map;	//노드의 연결 정보 저장
	static boolean[] visited;	//노드의 방문 여부 확인 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		vertex=sc.nextInt();
		edge=sc.nextInt();
		map=new int[vertex+1][vertex+1];	//1부터 사용하기 위해 +1
		visited=new boolean[vertex+1];
		
		// 노드 간의 연결정보 저장
		for(int i=0;i<edge;i++) {
			int start=sc.nextInt();	//현재 노드
			int end=sc.nextInt();	//연결된 노드
			
			map[start][end]=1;
			map[end][start]=1;	//한 방향으로 연결되는 경우 해당 코드 불필요
		}
		dfs(1);
		sc.close();
	}
	//재귀 함수를 이용해 구현
	public static void dfs(int start) {
		visited[start]=true;
		System.out.print(start+" ");
		
		for(int i=1;i<vertex+1;i++) {
			if(map[start][i]==1&&visited[i]==false) {
				dfs(i);
			}
		}
	}
}
