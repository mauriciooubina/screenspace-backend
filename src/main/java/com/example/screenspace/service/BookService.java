package com.example.screenspace.service;

import com.example.screenspace.model.Book;
import com.example.screenspace.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    public Book createBook(Book Book) {
        return bookRepository.save(Book);
    }

    public Book updateBook(Integer bookId, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            updatedBook.setId(bookId);
            return bookRepository.save(updatedBook);
        }
        return null;
    }

    public boolean deleteBook(Integer bookId) {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            bookRepository.delete(existingBook.get());
            return true;
        }
        return false;
    }
}
