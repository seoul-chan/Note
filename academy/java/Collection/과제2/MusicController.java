package com.kh.practice.list.music.model.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	
	public int addAtZero(Music music) {
		list.add(0,music);
		return 1;
	}
	
	public List<Music> printAll() {
		return list;
	}
	
	public Music searchMusic(String title) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getTitle().equals(title))
				return list.get(i);
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getTitle().equals(title)) {
				Music m =list.get(i); 	//¾èÀº º¹»ç??????????????
				list.remove(i);
				return m;
			}
		}
		return null;
	}
	
	public Music setMusic(String title, String singer) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getTitle().equals(title)) {
				list.get(i).setTitle(title);
				list.get(i).setSinger(singer);
				
				return list.get(i);
			}		
		}
		return null;
	}
	
	public int ascTitle() {
		Collections.sort(list);
		return 1;
	}
	
	public int descSinger() {
		Collections.sort(list, new AscTitle());
		return 1;
	}
}
