package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;


import com.bookstore.bookstore.model.Book;

public interface BookService {

	public Book createBooks(Book book);

	public List<Book> getBooks();

	public Optional<Book> getBooks(int id) throws Exception;

	public Book updateBook(Book book) throws Exception;

	public String deleteBookbyId(int id) throws Exception;

	public void inputValidation(Book book);

	public Book patchBook(Book book);

}
