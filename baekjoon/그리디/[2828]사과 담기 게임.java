package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//2828번 - 사과 담기 게임
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine()," ");
    	int n=Integer.parseInt(st.nextToken());
    	int m=Integer.parseInt(st.nextToken());
    	int j=Integer.parseInt(br.readLine());
    	int start=1, end=m, count=0, apple=0; //start~end : 바구니 길이
    	
    	for(int i=0;i<j;i++) {
    		int temp=0;
    		apple=Integer.parseInt(br.readLine());
    		if(apple>end) {	//바구니 오른쪽 이동
    			temp=apple-end;
    			start+=temp;
    			end+=temp;
    		} else if(apple<start) { //바구니 왼쪽 이동
    			temp=start-apple;
    			start-=temp;
    			end-=temp;
    		}
			count+=temp;
    	}
    	System.out.println(count);
    }	
}