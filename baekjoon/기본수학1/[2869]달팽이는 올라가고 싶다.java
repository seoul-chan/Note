package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int up=Integer.valueOf(st.nextToken());
			int down=Integer.valueOf(st.nextToken());
			int length=Integer.valueOf(st.nextToken());
			
			int count=(length-down)/(up-down);
			
			if((length-down)%(up-down)!=0) count++;
			System.out.println(count);
		}catch(IOException e) {
			e.printStackTrace();
		}
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