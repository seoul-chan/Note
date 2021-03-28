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
    	int start=1, end=m, count=0, apple=0;
    	
    	for(int i=0;i<j;i++) {
    		apple=Integer.parseInt(br.readLine());
    		if(apple>end) {
    			count+=(apple-end);
    			start+=(apple-end);
    			end+=(apple-end);
    		} else if(apple<start) {
    			count+=Math.abs(apple-start);
    			start+=(apple-start);
    			end+=(apple-start);
    		}                                                                                                                                                                                 
    	}
    	System.out.println(count);
    }	
}