package com.lib.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.lib.management.model.Book;
import com.lib.management.service.LibraryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * Author : nikhi
 * Date   : 28-Dec-2024
 * Time   : 7:49:05 am
*/

@Controller
public class LibraryController {
	
	@Autowired
	LibraryService libraryService ;
	
	@GetMapping("/")
	public String getMethodName() {
		return "index";
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute(book);
		return "add";
	}
	
	@PostMapping("/add")
	public String postMethodName(@ModelAttribute("book") Book book) {
		
		libraryService.addBook(book);
		
		return "redirect:/" ;
	}
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		List<Book> books = libraryService.getBooks();
		model.addAttribute("book", books);
		return "book-list";
	}
	
	@GetMapping("/delete/{bookId}")
	public String delete(@PathVariable int bookId) {
		
		libraryService.deleteId(bookId);
		
		return "redirect:/books";
	}
	
	@GetMapping("/edit/{bookId}")
	public String updateForm(@PathVariable int bookId , Model model) {
		Book book = libraryService.getSingleBook(bookId);
		model.addAttribute("book", book);
		return "update";
	}
	
	@PostMapping("/edit/{bookId}")
	public String updateStudent(@PathVariable("bookId") int bookId , 
			@ModelAttribute("book") Book book) {
		book.setBookId(bookId);
		libraryService.update(book);
		return "redirect:/books";
	}
	
	
	
	

}
