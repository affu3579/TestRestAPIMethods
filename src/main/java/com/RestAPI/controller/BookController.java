package com.RestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.entity.Book;
import com.RestAPI.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

//	@GetMapping("/books")
//	public List<Book> getAllData()
//	{
//		return bookService.getAllData();
//	}

	@GetMapping("/books")
	public List<Book> get()
	{
		return this.bookService.getAllData();
	}
	@GetMapping("/books/{id}")
	public Book getSingleBook(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}
}
