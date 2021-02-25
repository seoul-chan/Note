package com.kh.practice.list.library.model.vo;

public class Book implements Comparable {
	private String title;
	private String author;
	private String category;
	private int price;
	
	public Book() {	}

	public Book(String title, String author, String category, int price) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}
	
	public void setTitle(String title) {this.title=title;}
	public void setAuthor(String author) {this.author=author;}
	public void setCategory(String category) {this.category=category;}
	public void setPrice(int price) {this.price=price;}
	
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public String getCategory() {return category;}
	public int getPrice() {return price;}
	
	@Override
	public String toString() {
		
		return ""; 
	}
	@Override
	public int hashCode() {
		
		return 0; 
	}
	@Override
	public boolean equals(Object obj) {
		
		return true;
	}
	@Override
	public int compareTo(Object obj) {
		
		return 0;
	}
}
