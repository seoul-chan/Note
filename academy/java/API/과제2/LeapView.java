package com.kh.practice.leap.view;

import java.util.Calendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	public LeapView() {
		Calendar cal = Calendar.getInstance();
		LeapController lc = new LeapController();
		int year = cal.get(Calendar.YEAR);
		long date = lc.leapDate(cal);

		System.out.println("현재 년도는 "+year+"도이며 "+((lc.isLeapYear(year))?"윤년":"평년")+"입니다.");
		System.out.println("1년 1월 1일부터 오늘까지 총 일수는 "+date+"일 입니다.");
	}
}
