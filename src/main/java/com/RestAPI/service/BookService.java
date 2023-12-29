package com.RestAPI.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.RestAPI.entity.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();
	
	static
	{
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
    
}
