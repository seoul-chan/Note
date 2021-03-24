package com.test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int day=sc.nextInt(),night=sc.nextInt(),tree=sc.nextInt();
		int move=0,count=0;
		
		while(true) {
			count++;
			if((move+=day)>=tree) break;
			move-=night;
		}
		System.out.println(count);
		System.out.println(20%7);
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int day=sc.nextInt(),night=sc.nextInt(),tree=sc.nextInt();
		int move=0,count=0;
		
		while(true) {
			count++;
			if((move+=day)>=tree) break;
			move-=night;
		}
		System.out.println(count);
	}
}
*/