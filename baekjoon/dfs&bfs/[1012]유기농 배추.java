package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int row;
    static int col;
    static int count=0;
    
    //1012번 - 유기농 배추
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        int t=Integer.parseInt(br.readLine());          //테스트 케이스
        
        while(t!=0) {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            col=Integer.parseInt(st.nextToken());       //가로
            row=Integer.parseInt(st.nextToken());;      //세로
            int point=Integer.parseInt(st.nextToken());;    //배추 개수
            map=new int[row][col];
            
            for(int i=0;i<point;i++) {
                st=new StringTokenizer(br.readLine()," ");
                int c=Integer.parseInt(st.nextToken());
                int r=Integer.parseInt(st.nextToken());
                map[r][c]=1;
            }
            
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    if(map[i][j]==1) {
                        bfs(i,j);
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
    
    public static void bfs(int x, int y) {
        Queue<Node> q=new LinkedList<Node>();
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        q.offer(new Node(x,y));
        map[x][y]=0;
        
        while(!q.isEmpty()) {
            Node node=q.poll();
            for(int i=0;i<4;i++) {
                int nx=node.x+dx[i];
                int ny=node.y+dy[i];
                
                if(nx>=0&&nx<row&&ny>=0&&ny<col&&map[nx][ny]==1) {
                    q.offer(new Node(nx,ny));
                    map[nx][ny]=0;
                }
            }
        }
    }
}
class Node{
    int x;
    int y;
    
    Node(int x,int y) {
        this.x=x;
        this.y=y;
    }
}