package com.lib.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.management.dao.LibraryDAO;
import com.lib.management.model.Book;

/**
 * Author : nikhi Date : 28-Dec-2024 Time : 7:49:33 am
 */
@Service
public class LibraryService {

	@Autowired
	private LibraryDAO libraryDao;

	public int addBook(Book book) {
		return libraryDao.addBook(book);
	}
	
	public List<Book> getBooks(){
		return libraryDao.getBooks();
	}

	public int deleteId(int id) {
		
		return libraryDao.delete(id);
		
	}

	public Book getSingleBook(int bookId) {
		
		return libraryDao.get(bookId);
	}

	public int update(Book book) {
		
		return libraryDao.update(book);
	}

}
