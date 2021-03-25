package com.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int n = sc.nextInt();
    	int a,b;
    	if(n%5==0) 
    		System.out.println(n/5);
    	else {
    		a=n/5;
    		b=n%5;
    		while(b<=n) {
    			if(b%3==0) {
    				System.out.println(a+b/3);
    				return;
    			}
    			b+=5;
    			a--;
    		}
    		System.out.println(-1);
    	}
    }
}

