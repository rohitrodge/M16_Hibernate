package com.tns.service;

import java.util.List;

import com.tns.entities.Book;

public interface BookService {
	public abstract Book getBookById(int ID);
	public abstract List<Book> getBookByTitle(String Title);
	public abstract Long getBookCount();
	public abstract List<Book> getAuthorBooks(String author);
	public abstract List<Book> getAllBooks();
	public abstract List<Book> getBooksInPriceRange(double low, double high);

}