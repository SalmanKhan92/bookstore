package com.bookstore.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.exceptions.InputException;
import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBooks(Book book){
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getBooks() {
		 List<Book> bookList = bookRepository.findAll();
		 if(!bookList.isEmpty())
			 return bookList;
		 else throw new InputException();
	}

	@Override
	public Optional<Book> getBooks(int id) throws Exception{
		return bookRepository.findById(id);
	}

	@Override
	public Book updateBook(Book book) throws Exception{
		Book updatedBook = null;
		Optional<Book> oldBook = bookRepository.findById(book.getId());
		if (oldBook.isPresent()) {
			updatedBook = oldBook.get();
			updatedBook.setName(book.getName());
			updatedBook.setAuthor(book.getAuthor());
			updatedBook.setCategory(book.getCategory());
			updatedBook.setDescription(book.getDescription());
			updatedBook.setPrice(book.getPrice());
			updatedBook.setIsbn(book.getIsbn());
			updatedBook.setClassification(book.getClassification());
			bookRepository.save(updatedBook);
		} else {
			throw new NullPointerException();
		}
		return updatedBook;
	}

	@Override
	public Book patchBook(Book book) {
		Book updatedBook = null;
		Optional<Book> oldBook = bookRepository.findById(book.getId());
		if (oldBook.isPresent()) {
			updatedBook = oldBook.get();
				updatedBook.setName(book.getName());
				updatedBook.setName(book.getName());
				updatedBook.setAuthor(book.getAuthor());
				updatedBook.setCategory(book.getCategory());
				updatedBook.setPrice(book.getPrice());
				updatedBook.setIsbn(book.getIsbn());
				updatedBook.setClassification(book.getClassification());
				if(book.getDescription()!=null && book.getDescription().isEmpty())
					updatedBook.setDescription(book.getDescription());
				bookRepository.save(updatedBook);
		} else {
			throw new NullPointerException();
		}
		return updatedBook;
	}
	
	@Override
	public String deleteBookbyId(int id) throws Exception{
		try {
		bookRepository.deleteById(id);
		return "Delete the book successfully";
		}catch(Exception e){
			throw new NullPointerException();
		}
	}
	
	@Override
	public void inputValidation(Book book) {
		if(book.getName().isEmpty() || book.getName().length()==0)
			throw new InputException();
		if(book.getAuthor().isEmpty() || book.getAuthor().length()==0)
			throw new InputException();
		if(book.getCategory().isEmpty() || book.getCategory().length()==0)
			throw new InputException();
		if(book.getPrice()== 0)
			throw new InputException();
		if(book.getIsbn().isEmpty() || book.getIsbn().length()==0)
			throw new InputException();
		else if(book.getClassification()==null)
			throw new InputException();	
	}
}
