package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    // 2630번 - 색종이 만들기
    static int white=0;
    static int blue=0;
    static int board[][];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        board=new int[n][n];
        
        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }  
        partition(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }
    
    public static void partition(int row, int col, int size) {
        //현재 파티션이 모두 같은 색상이면 색상 증가 후 종료
        if(colorCheck(row, col, size)) {
            if(board[row][col]==0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        
        int newSize=size/2; // 사이즈를 절반으로 줄인다.

        partition(row, col, newSize);   //분할된 1~4사분면
        partition(row, col+newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);       
        
    }
    
    // 종이의 색깔이 모두 같은지 확인
    public static boolean colorCheck(int row, int col, int size) {
        
        int color=board[row][col];
        
        for(int i=row;i<row+size;i++) {
            for(int j=col;j<col+size;j++) {
                if(board[i][j]!=color)
                    return false;
            }
        }
        return true;
    }
}