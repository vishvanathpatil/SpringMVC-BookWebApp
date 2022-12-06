package com.bookstore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookstore.mapper.BookRowMapper;
import com.bookstore.model.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	private static final String INSERT_SQL = "INSERT INTO BOOK_TBL (BOOK_NAME,BOOK_PRICE,BOOK_ISBN,AUTHOR_NAME,ACTIVE_SW) VALUES (?,?,?,?,?)";
	private static final String FIND_BY_ISBN = "SELECT * FROM BOOK_TBL WHERE BOOK_ISBN=?";
	private static final String FIND_ALL = "SELECT * FROM BOOK_TBL WHERE ACTIVE_SW='Y'";

	@Autowired(required = true)
	private JdbcTemplate jdbcTemplate;

	/**
	 * This method is used to insert a book record
	 */
	public boolean saveBook(Book book) {

		int cnt = jdbcTemplate.update(INSERT_SQL, book.getBookName(), book.getBookPrice(), book.getBookIsbn(),
				book.getAuthorName(), book.getActiveSw());

		return (cnt > 0 ? true : false);
	}

	/**
	 * This method is used to retrieve all records which are active
	 */
	public List<Book> findAll() {
		return jdbcTemplate.query(FIND_ALL, new BookRowMapper());
	}

	/**
	 * This method is used to retrieve one book record using given isbn
	 */
	public List<Book> findByIsbn(String isbn) {
		return jdbcTemplate.query(FIND_BY_ISBN, new Object[] { isbn }, new BookRowMapper());
	}

	public List<Book> searchBooks(Book b) {
		 StringBuffer BASE_SELECT_SQL = new StringBuffer("SELECT * FROM BOOK_TBL WHERE 1=1");
		if (null != b.getBookName() && !"".equals(b.getBookName())) {
			BASE_SELECT_SQL.append(" AND BOOK_NAME LIKE '%" + b.getBookName() + "%'");
		}

		if (null != b.getAuthorName() && !"".equals(b.getAuthorName())) {
			BASE_SELECT_SQL.append(" AND AUTHOR_NAME LIKE '%" + b.getAuthorName() + "%'");
		}

		if (null != b.getBookPrice() && !"".equals(b.getBookPrice())) {
			BASE_SELECT_SQL.append(" AND BOOK_PRICE =" + b.getBookPrice());
		}
		System.out.println(BASE_SELECT_SQL);
		return jdbcTemplate.query(BASE_SELECT_SQL.toString(), new BookRowMapper());
	}

}
