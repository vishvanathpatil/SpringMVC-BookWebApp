package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;

public interface BookService {

	public boolean saveBook(Book book);

	public List<Book> findAllBooks();

	public List<Book> findBookByIsbn(String isbn);

	public List<Book> searchBooks(Book b);

}
