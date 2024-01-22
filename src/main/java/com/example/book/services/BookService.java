package com.example.book.services;

import com.example.book.entity.Book;

import java.util.List;

public interface BookService {

    public void createBook(String name, String title, String author);

    public List <Book> getAllBook();

    public  void deleteBook(long id);


}
