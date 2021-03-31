package com.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class DfsList {

	static int edge;	// 노드간 연결하는 간선의 수
	static int vertex;	// 노드(데이터)의 개수
	static ArrayList<ArrayList<Integer>> map;	// 노드 연결 정보 저장
	static boolean[] visited;	// 노드 방문 여부 확인
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		vertex=sc.nextInt();
		edge=sc.nextInt();
		map=new ArrayList<ArrayList<Integer>>();
		visited=new boolean[vertex+1];
		
		for(int i=0;i<vertex+1;i++)	//index 1부터 사용하기에 vertex+1 
			map.add(new ArrayList<Integer>());	// 인접 리스트의 리스트 초기화
		
		for(int i=0;i<edge;i++) {
			System.out.print("start : ");
			int start=sc.nextInt();
			System.out.print("end : ");
			int end=sc.nextInt();
			System.out.println();
			
			map.get(start).add(end);	// 인접 리스트 안의 리스트에 값 저장 
			map.get(end).add(start);
		}
		dfs(1);
		sc.close();
	}
	
	public static void dfs(int start) {
		visited[start]=true;
		System.out.print(start+" ");
		
		// 리스트의 null check를 위해 for each 사용
		// for each사용 시 리스트안의 리스트의 값을 순차적으로 불러온다. (그래서 int형으로 반환)
		for(int i : map.get(start)) {
			if(visited[i]==false)
				dfs(i);
		}
	}
}
