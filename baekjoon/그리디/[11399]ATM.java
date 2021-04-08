package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {	
	//11399번 - ATM
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int people=Integer.parseInt(br.readLine());
		int[] time=new int[people];
		String[] str=br.readLine().split(" ");
		int temp=0, sum=0;
		
		for(int i=0;i<people;i++)
			time[i]=Integer.parseInt(str[i]);
		
		Arrays.sort(time);
		for(int i=0;i<people;i++) {
			temp+=time[i];
			sum+=temp;			
		}
		
		System.out.println(sum);
	}
}