package com.RestAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.entity.Book;
import com.RestAPI.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

//	@GetMapping("/books")
//	public List<Book> getAllData()
//	{
//	return bookService.getAllData();
//	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>>get()
	{
		List<Book> book= bookService.getAllData();
		if(book.size()<=0) {
			//http response status methods
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	@GetMapping("/books/{id}")
	public Book getSingleBook(@PathVariable("id") int id) {
	return this.bookService.getBookById(id);
		
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		//TODO: process POST request
		 this.bookService.addBook(book);
		return book;
	}
	@DeleteMapping("/books/{bookId}")
	public void DeleteBook(@PathVariable("bookId") int bookId)
	{
		this.bookService.DeleteBook(bookId);
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		//TODO: process PUT request
		this.bookService.updateBook(id,book);
		return book;
	}
}
