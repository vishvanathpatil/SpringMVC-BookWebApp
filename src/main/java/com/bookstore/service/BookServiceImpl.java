package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.BookDao;
import com.bookstore.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired(required = true)
	private BookDao bookDao;

	public boolean saveBook(Book book) {
		book.setActiveSw("Y");
		return bookDao.saveBook(book);
	}

	public List<Book> findAllBooks() {
		return bookDao.findAll();
	}

	public List<Book> findBookByIsbn(String isbn) {
		return bookDao.findByIsbn(isbn);
	}

	public List<Book> searchBooks(Book b) {
		return bookDao.searchBooks(b);
	}
	
	public void m1(){
		
	}
}
