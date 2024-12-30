package com.lib.management.model;

/**
 * Author : nikhi
 * Date   : 28-Dec-2024
 * Time   : 7:48:45 am
*/
public class Book {
	
	private int bookId ;
	private String bookName ;
	private String author ;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(int bookId, String bookName, String author) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}
	
	public Book() {
		
	}
	
}
