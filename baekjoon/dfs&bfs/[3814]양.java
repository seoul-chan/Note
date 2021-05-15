package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int row,col,sheep=0,woolf=0;
	static char[][] map;
	static boolean[][]visited;
	
	// 3814번 - 양
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		map=new char[row][col];
		visited=new boolean[row][col];
		
		for(int i=0;i<row;i++) {
			String str=br.readLine();
			for(int j=0;j<col;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		int count1=0, count2=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(map[i][j]=='o'||map[i][j]=='v') {
					bfs(i,j);
					if(sheep>woolf) count1+=sheep;
					else count2+=woolf;
				}
			}
			sheep=0;
			woolf=0;
		}
		System.out.println(count1+" "+count2);
		
	}
	
	public static void bfs(int x, int y) {
		visited[x][y]=true;
		System.out.println("map : "+map[x][y]);
		if(map[x][y]=='o') sheep++;
		if(map[x][y]=='v') woolf++;
		
		System.out.println("sheep : "+sheep);
		System.out.println("woolf : "+sheep);
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(new Node(x,y));
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=node.x+dx[i];
				int ny=node.y+dy[i];
				
				if(map[nx][ny]!='#'&&visited[nx][ny]==false) {
					queue.offer(new Node(nx,ny));
					if(map[node.x][node.y]=='o') sheep++;
					if(map[node.x][node.y]=='v') woolf++;
					visited[nx][ny]=true;
					
					System.out.println("sheep : "+sheep);
					System.out.println("woolf : "+sheep);
				}
			}
			
		}
		System.out.println("sheep : "+sheep);
		System.out.println("woolf : "+sheep);
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
/*
 
 public class Main {
	static int edge;
	static int vertex;
	static ArrayList<ArrayList<Integer>> map;
	static boolean[] visited;
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("vertex : ");
		vertex=sc.nextInt();
		System.out.print("edge : ");
		edge=sc.nextInt();
		map=new ArrayList<ArrayList<Integer>>();
		visited=new boolean[vertex+1];
		
		for(int i=0;i<vertex+1;i++) {
			map.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edge;i++) {
			System.out.print("start end : ");
			int start=sc.nextInt();
			int end=sc.nextInt();
			
			map.get(start).add(end);
			map.get(end).add(start);
		}
		dfs(1);
		sc.close();		
	}
	
	public static void dfs(int start) {
		visited[start]=true;
		System.out.print(start+" ");
		
		for(int i : map.get(start)) {
			if(visited[i]==false) {
				dfs(i);
			}
		}
	}
 
 =================================================
 
 public class Main {
	static int edge;
	static int vertex;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("vertex : ");
		vertex=sc.nextInt();
		System.out.print("edge : ");
		edge=sc.nextInt();
		map=new int[vertex+1][vertex+1];
		visited=new boolean[vertex+1];
		
		for(int i=0;i<edge;i++) {
			System.out.print("start end : ");
			int start=sc.nextInt();
			int end=sc.nextInt();
			
			map[start][end]=1;
			map[end][start]=1;
		}
		dfs(1);
		sc.close();
		
	}
	
	public static void dfs(int start) {
		visited[start]=true;
		System.out.print(start+" ");
		
		for(int i=1;i<vertex+1;i++) {
			if(map[start][i]==1&&visited[i]==false) {
				dfs(i);
			}
		}
	}

*/