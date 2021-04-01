package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BfsMetrix {
	static int node;			//노드(데이터)의 개수
	static int edge;			//노드간 연결하는 간선의 수
	static int[][] map;			//노드 연결 정보 저장
	static boolean[] visited;	//노드의 방문 여부 확인 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		node=sc.nextInt();
		edge=sc.nextInt();
		map=new int[node+1][node+1];	//1부터 사용하기 위해 +1
		visited=new boolean[node+1];
		
		sc.nextLine();
		for(int i=0;i<edge;i++) {
			StringTokenizer st=new StringTokenizer(sc.nextLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			map[start][end]=1;
			map[end][start]=1;			
		}
		bfs(1);
		sc.close();
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.offer(start);		//node의 값을 큐에 저장
		visited[start]=true;	//방문처리
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();	//큐에 값을 꺼낸 후 출력
			System.out.print(temp+" ");
			
			// 노드와 연결된 노드들을 큐에 저장
			for(int i=1;i<node+1;i++) {
				if(map[temp][i]==1&&visited[i]==false) { // 연결되어 있고 방문하지 않은 경우
					queue.offer(i);
					visited[i]=true;	//큐에 저장 후 바로 방문처리 이유는?? 
										// 해당 노드 호출 전 다른 연결된 노드에서도 해당 노드를 큐에 넣는 것을 방지 
				}
			}
		}
	}
}
