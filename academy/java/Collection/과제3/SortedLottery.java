package com.kh.practice.set.model.compare;

import java.util.Comparator;

import com.kh.practice.set.model.vo.Lottery;

public class SortedLottery implements Comparator<Lottery>{
	
	@Override
	public int compare(Lottery lo1, Lottery lo2) {			
			if((lo1.getName().compareTo(lo2.getName())==0))
					return lo1.getPhone().compareTo(lo2.getPhone());
			
			return lo1.getName().compareTo(lo2.getName());
	}
}
