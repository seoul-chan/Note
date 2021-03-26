package com.test;

import java.util.Scanner;

public class Main {
	//5585번 - 거스름돈
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int[] change=new int[] {500,100,50,10,5,1};
    	int money=1000-sc.nextInt(), count=0;
    	for(int i : change) {
    		count+=money/i;
    		money%=i;
    	}
    	System.out.println(count);    	
    }
}

