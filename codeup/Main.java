package com.test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = Integer.valueOf(sc.next(),8);
		System.out.printf("%d",i);
	}
}

/*
	
	CodeUp-1034
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = Integer.valueOf(sc.next(),8);
		System.out.printf("%d",i);
	}
	
	CodeUp-1033
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%X",sc.nextLong());
	}
	
	CodeUp-1032
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%x",sc.nextLong());
	}
	
	CodeUp-1031
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%o",sc.nextLong());
	}
	
	CodeUp-1030
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLong());
	}
	
	CodeUp-1029
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%.11f",sc.nextDouble());
	}
	
	CodeUp-1028
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLong());
	}
	
	CodeUp-1027
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sArr = sc.next().split("\\.");
		int[] iArr = new int[sArr.length];
		for(int i=0;i<sArr.length;i++) {
			iArr[i]=Integer.parseInt(sArr[i]);
		}
		System.out.printf("%02d-%02d-%04d",iArr[2],iArr[1],iArr[0]);
	}
	
	CodeUp-1026
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sArr = sc.next().split(":");
		int[] iArr = new int[sArr.length];
		for(int i=0;i<sArr.length;i++) {
			iArr[i]=Integer.parseInt(sArr[i]);
		}
		System.out.println(iArr[1]);
	}
	
	CodeUp-1025
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sArr = sc.next().split("");
		int[] iArr = new int[sArr.length];
		for(int i=0;i<sArr.length;i++) {
			int temp=1;
			for(int j=1;j<sArr.length-i;j++)
				temp*=10;	
			iArr[i]=Integer.parseInt(sArr[i])*temp;
			System.out.println("["+iArr[i]+"]");
		}
	}
	
	CodeUp-1024
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cArr = sc.next().toCharArray();
		for(int i=0;i<cArr.length;i++)
			System.out.println("'"+cArr[i]+"'");		
	}
	
	CodeUp-1008
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("\u250c\u252c\u2510\n"
				+ "\u251c\u253c\u2524\n"
				+ "\u2514\u2534\u2518");		
	}

	CodeUp-1020
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.next().replace("-", ""));		
	}

 	CodeUp-1019
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] days = sc.next().split("\\.");
		int[] day = new int[days.length];
		for(int i=0;i<days.length;i++)
			day[i] = Integer.valueOf(days[i]);
				
		System.out.printf("%04d.%02d.%02d",day[0],day[1],day[2]);
	}
*/

