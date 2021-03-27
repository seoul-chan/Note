package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//14659번 - 한조서열정리하고옴
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int peaks=Integer.parseInt(br.readLine());
    	String[] heights = br.readLine().split(" ");
    	int cur_height=Integer.parseInt(heights[0]);
    	int count=0,max=0;
    	
    	for(int i=1;i<peaks;i++) {
    		int height=Integer.parseInt(heights[i]);
    		
    		if(cur_height>height) {
    			count++;
    			if(count>max)
    				max=count;
    		}else {
    			cur_height=height;
    			count=0;
    		}
    	}
    	System.out.println(max);
    }	
}