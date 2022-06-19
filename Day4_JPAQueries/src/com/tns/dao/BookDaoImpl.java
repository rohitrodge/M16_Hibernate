package com.tns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tns.entities.Book;

public class BookDaoImpl implements BookDao {
	private EntityManager entityManager;
	

	public BookDaoImpl() {
		entityManager=JPAUtil.getEntityManager();
		
	}


	public Book getBookById(int ID) {
		Book book=entityManager.find(Book.class, ID);
		return book;
	}

	
	public List<Book> getBookByTitle(String Title) {
		String qStr = "SELECT book FROM Book book WHERE book.Title=pTitle";
		TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
		query.setParameter("pTitle", "Introduction to JPA");
		
		return query.getResultList();
	}

	
	public Long getBookCount() {
		String qStr = "SELECT COUNT(book.ID) FROM Book book";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count=query.getSingleResult();
		return count;
		
	}

	@Override
	public List<Book> getAuthorBooks(String Author) {
		String qStr = "SELECT book FROM Book book WHERE book.Author=pAuthor";
		TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
		query.setParameter("pAuthor", Author);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		Query query=entityManager.createNamedQuery("getAllBooks");
		return query.getResultList();
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		String qStr = "SELECT book FROM Book book WHERE book.price BETWEEN : Low and :high";
		TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		
		return query.getResultList();
	}

}