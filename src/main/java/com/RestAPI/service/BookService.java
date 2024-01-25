package com.RestAPI.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RestAPI.entity.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();
	
	static
	{
		// comment these added list to get Not found http response method
		list.add(new Book(1, "java", "QY"));
		list.add(new Book(2, "Python", "ABC"));
		list.add(new Book(3, "Springboot", "ZXC"));
	}
	
	public List<Book> getAllData()
	{
		return list;
	}
	
    public Book getBookById(int id){
    	Book book=null;
    	book=list.stream().filter(e->e.getId()==id).findFirst().get();
    	return book;
    }

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		list.add(book);
		
		
	}

	public void DeleteBook(int bookId) {
		// TODO Auto-generated method stub
		list =list.stream().filter(e->e.getId() != bookId).collect(Collectors.toList());
	}

	public void updateBook(int id,Book book) {
		// TODO Auto-generated method stub
		
		list=list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			
			return b;
		}).collect(Collectors.toList());
		
	}
    
}
