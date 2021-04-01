package com.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BfsList {
	static int node;							//노드(데이터)의 개수
	static int edge;							//노드간 연결하는 간선의 수
	static ArrayList<ArrayList<Integer>> map;	//노드 연결 정보 저장
	static boolean[] visited;					//노드의 방문 여부 확인 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		node=sc.nextInt();
		edge=sc.nextInt();
		map=new ArrayList<ArrayList<Integer>>();	//1부터 사용하기 위해 +1
		visited=new boolean[node+1];
		
		for(int i=0;i<node+1;i++)
			map.add(new ArrayList<Integer>());
		
		sc.nextLine();
		for(int i=0;i<edge;i++) {
			StringTokenizer st=new StringTokenizer(sc.nextLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			map.get(start).add(end);
			map.get(end).add(start);
		}
		bfs(1);
		sc.close();
	}
	public static void bfs(int start) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.offer(start);		//node의 값을 큐에 저장
		visited[start]=true;	//방문처리
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			System.out.print(temp+" ");

			//리스트의 null check를 위해 for each 사용
			//for each사용 시 리스트안의 리스트의 값을 순차적으로 불러온다. (그래서 int형으로 반환가능)
			for(int i : map.get(temp)) {
				if(visited[i]==false) {
					queue.offer(i);
					visited[i]=true;
				}
			}
		}
	}
}
