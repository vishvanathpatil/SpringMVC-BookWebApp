package com.bookstore.dao;

import java.util.List;

import com.bookstore.model.Book;

public interface BookDao {

	public boolean saveBook(Book book);

	public List<Book> findAll();

	public List<Book> findByIsbn(String isbn);

	public List<Book> searchBooks(Book b);

}
