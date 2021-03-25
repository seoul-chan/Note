package com.test;

import java.util.Scanner;

public class Main {
	//10162번 - 전자레인지
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] time=new int[] {300, 60, 10};
    	
    	if(n%10!=0) {
    		System.out.println(-1);
    	} else {
    		for(int i : time) {
    			int temp=n/i;
    			n%=i;
    			System.out.print(temp+" ");
    		}    		
    	}
    }
}

