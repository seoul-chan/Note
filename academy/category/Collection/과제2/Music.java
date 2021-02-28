package com.kh.practice.list.music.model.vo;

public class Music implements Comparable{
	private String title;
	private String singer;
	
	public Music() { }
	public Music(String title, String singer) {
		this.title=title;
		this.singer=singer;
	}
	
	public void setTitle(String title) {this.title = title;	}
	public void setSinger(String singer) {this.singer = singer;}
	public String getTitle() {return title;}
	public String getSinger() {return singer;}
	
	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	
	@Override
	public int hashCode() {
		return (title+singer).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Music) {
			Music m = (Music)obj;
			if(title.equals(m.title)&&singer.equals(m.singer))
				return true;
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Music) {
			Music m = (Music)o;
			return title.compareTo(m.title);
		}
		return 0;
	}
}
