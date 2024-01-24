package com.example.book.services;

import com.example.book.bookRepository.BookRepository;
import com.example.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public void createBook(String name, String title, String author) {
        Book book = new Book();
        book.setName(name);
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.save(book);

    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList;
        bookList =bookRepository.findAll();
        return bookList;
    }

    @Override
    public Book getBook(long id) {
        Optional<Book> optionalBook;
        optionalBook= bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            return book;
        }
        return null;
    }

    @Override
    public List<Book> searchBooksByName(String name) {
        return bookRepository.findByNameContainingIgnoreCase(name);
    }


    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}









