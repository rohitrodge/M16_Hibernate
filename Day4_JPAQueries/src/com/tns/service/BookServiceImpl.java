package com.tns.service;

import java.util.List;

import com.tns.dao.BookDao;
import com.tns.dao.BookDaoImpl;
import com.tns.entities.Book;

public class BookServiceImpl implements BookService{
	private BookDao dao;
	
	

	public BookServiceImpl() {
		dao=new BookDaoImpl();
	}

	@Override
	public Book getBookById(int ID) {
		
		return dao.getBookById(ID);
	}

	@Override
	public List<Book> getBookByTitle(String Title) {
		
		return dao.getBookByTitle(Title);
	}

	@Override
	public Long getBookCount() {
		// TODO Auto-generated method stub
		return dao.getBookCount();
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		// TODO Auto-generated method stub
		return dao.getAuthorBooks(author);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return dao.getAllBooks();
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		// TODO Auto-generated method stub
		return dao.getBooksInPriceRange(low, high);
	}
	

}