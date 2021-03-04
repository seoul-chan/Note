package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<Lottery>();
	private HashSet<Lottery> win = new HashSet<Lottery>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		boolean flag = lottery.remove(l);
		if(flag && win.contains(l))
			win.remove(l);
			
		return flag;
	}
	
	public HashSet<Lottery> winObject() {
		ArrayList<Lottery> lotList = new ArrayList<Lottery>(lottery);
		if(lotList.size()>4)
			for(int i=0; i<4;i++) {
				win.add(lotList.get(i));
			}
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject() {
		if(win==null) return null;
		
		TreeSet<Lottery> ts = new TreeSet<Lottery>(new SortedLottery());
		ts.addAll(win);
		
		return ts;
	}
	
	public boolean searchWinner(Lottery lo) {
		
		return win.contains(lo);
	}
}
