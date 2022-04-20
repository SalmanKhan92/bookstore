package com.bookstore.bookstore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.exceptions.InputException;
import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;

	@GetMapping("/books")
	public ResponseEntity<?> getAllBook() {
		List<Book> bookList = null;
		bookList = bookservice.getBooks();
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}

	@PostMapping("/createBook")
	public ResponseEntity<String> createBook(@Valid @RequestBody Book book) {
		bookservice.inputValidation(book);
		bookservice.createBooks(book);
		return new ResponseEntity<String>("Successfully created a book", HttpStatus.CREATED);

	}

	@GetMapping("/books/{id}")
	public ResponseEntity<?> getAllBook(@PathVariable("id") int id) {
		try {
			Optional<Book> book = bookservice.getBooks(id);
			return new ResponseEntity<>(book.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("No books found with the given id", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id) {
		try {
			bookservice.deleteBookbyId(id);
			return new ResponseEntity<String>("Delete the book successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Unable to find book with the given id", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<String> UpdateBook(@RequestBody Book book, @PathVariable("id") int id) {
		bookservice.inputValidation(book);
		try {
			bookservice.updateBook(book);
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Unable to find book with the given id", HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/books/{id}")
	public ResponseEntity<String> patchBook(@PathVariable int id, @RequestBody Book book) {
		bookservice.inputValidation(book);
		try {
			bookservice.patchBook(book);
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Unable to find book with the given id", HttpStatus.NOT_FOUND);
		}
		
	}
}
