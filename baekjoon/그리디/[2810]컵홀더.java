package com.test;

import java.util.Scanner;

public class Main {
	//2810번 - 컵홀더
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int line=sc.nextInt();
    	String seat=sc.next();
    	int count=1;
    	for(int i=0;i<line;i++) {
    		if(seat.charAt(i)=='S') count++;
    		else {
    			count++;
    			i++;
    		}
    	}
    	if(line<count) 
    		System.out.println(line);
    	else
    		System.out.println(count);
    }
}