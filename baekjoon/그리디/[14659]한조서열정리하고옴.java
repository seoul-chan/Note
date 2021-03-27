package com.test;

import java.util.Scanner;

public class Main {
	//14659번 - 한조서열정리하고옴
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int mount=sc.nextInt();
    	int[] arr=new int[mount];
    	int count=0,max=0;
    	
    	for(int i=0;i<mount;i++) {
    		arr[i]=sc.nextInt();
    	}
    	
    	for(int i=0;i<mount;i++) {
    		for(int j=i+1;j<mount;j++) {
    			if(arr[i]>arr[j]) count++;
    			else break;
    		}
    		if(count>max) max=count;
    		count=0;
    	}
    	System.out.println(max);
    }	
}