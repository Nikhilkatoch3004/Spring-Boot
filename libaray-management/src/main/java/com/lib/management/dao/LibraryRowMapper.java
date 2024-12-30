package com.lib.management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lib.management.model.Book;

/**
 * Author : nikhi
 * Date   : 28-Dec-2024
 * Time   : 8:44:54 am
*/
public class LibraryRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book book = new Book();
		book.setBookId(rs.getInt("bookId"));
		book.setBookName(rs.getString("bookName"));
		book.setAuthor(rs.getString("author"));
		
		return book;
	}
	
}
