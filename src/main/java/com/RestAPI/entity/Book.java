package com.RestAPI.entity;


public class Book {

	private int id;
	private String title;
	private String Author;
	public Book(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		Author = author;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", Author=" + Author + "]";
	}
	
	
}
