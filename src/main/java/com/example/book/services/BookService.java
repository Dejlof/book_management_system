package com.example.book.services;

import com.example.book.entity.Book;

import java.util.List;

public interface BookService {

    public void createBook(String name, String title, String author);

    public List <Book> getAllBook();

    Book getBook (long id);

    public List<Book> searchBooksByName(String name);

    public  void deleteBook(long id);


    void updateBook(Book book);
}
