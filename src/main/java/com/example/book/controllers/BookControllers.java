package com.example.book.controllers;

import com.example.book.entity.Book;
import com.example.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/Book")
public class BookControllers {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book/index");
        modelAndView.addObject("message", "I Love You");
        return modelAndView;

    }
    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book/register");
        modelAndView.addObject("message", "I Love You");
        return modelAndView;

    }

    @RequestMapping(value = "/Create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam (value = "name") String name, @RequestParam(value = "title") String title, @RequestParam(value = "author") String author){
        ModelAndView modelAndView = new ModelAndView();
        bookService.createBook(name, title, author);
        modelAndView.addObject("books", bookService.getAllBook());
        modelAndView.setViewName("book/availablebooks");
        return modelAndView;
    };

    @RequestMapping(value = "/Available_Books", method = RequestMethod.GET)
    public ModelAndView availablebooks(){
        ModelAndView modelAndView = new ModelAndView();
        List <Book> bookList = bookService.getAllBook();
        modelAndView.addObject("books", bookList);
        modelAndView.setViewName("book/availablebooks");
        return modelAndView;

    }



}
