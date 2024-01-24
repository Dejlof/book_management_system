package com.example.book.controllers;

import com.example.book.entity.Book;
import com.example.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/BookApi")
public class BookApi {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/List", method = RequestMethod.GET)
   public ResponseEntity getAllBook(){
        List<Book> bookList = bookService.getAllBook();
        ResponseEntity response = new ResponseEntity(bookList, HttpStatus.OK);
        return response;

   }
}
