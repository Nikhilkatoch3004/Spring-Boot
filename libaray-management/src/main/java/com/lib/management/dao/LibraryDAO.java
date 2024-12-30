package com.lib.management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lib.management.model.Book;

/**
 * Author : nikhi Date : 28-Dec-2024 Time : 7:49:19 am
 */

@Repository
public class LibraryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addBook(Book book) {

		String query = "Insert into library(bookName , author) values(?,?)";
		return jdbcTemplate.update(query, book.getBookName(), book.getAuthor());

	}

	public List<Book> getBooks() {
		String query = "Select * from library";
		return jdbcTemplate.query(query, new LibraryRowMapper());
	}

	public int delete(int id) {
		String query = "Delete from library where bookId = ?";
		return jdbcTemplate.update(query, id);

	}

	public Book get(int bookId) {
		String query = "Select * from library where bookId = ?";
		return jdbcTemplate.queryForObject(query, new LibraryRowMapper(), bookId);
	}

	public int update(Book book) {
		String query = "update library set bookName=? , author =? where bookId = ?";

		return jdbcTemplate.update(query, book.getBookName(), book.getAuthor(), book.getBookId());
	}

}
