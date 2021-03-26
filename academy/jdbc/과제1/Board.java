package com.home.model.vo;

public class Board {
	private int idx;
	private String div;
	private String title;
	private String contests;
	private int writer;
	
	public Board() {}

	public Board(int idx, String div, String title, String contests, int writer) {
		this.idx=idx;
		this.div = div;
		this.title = title;
		this.contests = contests;
		this.writer = writer;
	}

	public int getIdx() {return idx;}
	public String getDiv() {return div;}
	public String getTitle() {return title;}
	public String getContests() {return contests;}
	public int getWriter() {return writer;}

	public void setIdx(int idx) {this.idx = idx;}
	public void setDiv(String div) {this.div = div;}
	public void setTitle(String title) {this.title = title;}
	public void setContests(String contests) {this.contests = contests;}
	public void setWriter(int writer) {this.writer = writer;}

	@Override
	public String toString() {
		return "Board [게시번호=" + idx + ", 항목=" + div + ", 제목=" + title + ", 내용=" + contests + ", 작성자="
				+ writer + "]";
	}
}
