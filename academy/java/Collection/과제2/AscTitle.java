package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Music && o2 instanceof Music) {
			Music m1 = (Music)o1;
			Music m2 = (Music)o2;
			
			return m2.getSinger().compareTo(m1.getSinger());
		}
		return 0;
	}
}
