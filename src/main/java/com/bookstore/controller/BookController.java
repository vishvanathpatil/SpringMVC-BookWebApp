package com.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/")
	public String displayBookForm(Model model) {
		Book b = new Book();
		model.addAttribute("b", b);
		return "storeBook";
	}

	@RequestMapping("/advBookSearchForm")
	public String advBookSearch(Model model) {
		Book b = new Book();
		model.addAttribute("b", b);
		return "searchBook";
	}

	@RequestMapping(name = "/saveBook", method = RequestMethod.POST)
	public String storeBook(@ModelAttribute("b") Book b, Model model) {

		boolean isSaved = bookService.saveBook(b);
		if (isSaved) {
			model.addAttribute("smsg", "Book Saved successfully.");
		} else {
			model.addAttribute("emsg", "Failed to save the Book.");
		}

		return "storeBook";
	}

	@RequestMapping("/search")
	public String searchBooks(HttpServletRequest req, Model model) {
		List<Book> booksList = null;

		// capturing isbn from req scope
		String isbn = req.getParameter("isbn");

		if ("".equals(isbn) || null == isbn) {
			// isbn not available
			booksList = bookService.findAllBooks();
		} else {
			// isbn available
			booksList = bookService.findBookByIsbn(isbn);
		}

		// adding data to model scope
		model.addAttribute("books", booksList);
		return "viewBooks";
	}

	@RequestMapping(value = "/booksAdvSearch", method = RequestMethod.POST)
	public String searchBooks(@ModelAttribute("b") Book b, Model model) {
		List<Book> booksList = null;

		booksList = bookService.searchBooks(b);
		// adding data to model scope
		model.addAttribute("books", booksList);

		return "searchBook";
	}

	@RequestMapping("/books")
	public String exportBooks(Model model) {
		List<Book> booksList = null;
		booksList = bookService.findAllBooks();
		model.addAttribute("books", booksList);
		return "viewBooks";
	}

}
