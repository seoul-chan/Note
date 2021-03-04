package com.kh.practice.leap.controller;

import java.util.Calendar;

public class LeapController {
	public boolean isLeapYear(int year) {
		
		return ((year%4==0)&&(year%100!=0)||(year%400==0))?true:false;
	}
	
	public long leapDate(Calendar c) {
		long sum=0;
		
		for(int i=1;i<c.get(Calendar.YEAR);i++) {
			if(isLeapYear(i)) {
//				System.out.print(i+"년 : 366일, sum = "); 합계 과정 확인 용도
				sum+=366;
			}
				else{
//					System.out.print(i+"년 : 365일, sum = "); 합계 과정 확인 용도
					sum+=365;
				}
//			System.out.println(sum); 합계 과정 확인 용도
		}
		return sum+c.get(Calendar.DAY_OF_YEAR);
	}
}
