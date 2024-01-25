package com.example.book.controllers;

import com.example.book.entity.Book;
import com.example.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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
        return modelAndView;

    }

    @RequestMapping(value = "/Create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam (value = "name") String name, @RequestParam(value = "title") String title, @RequestParam(value = "author") String author){
        ModelAndView modelAndView = new ModelAndView();
        if(name.length() != 0 && title.length() !=0 && author.length() != 0){
            bookService.createBook(name, title, author);
            modelAndView.addObject("books", bookService.getAllBook());
            modelAndView.setViewName("book/availablebooks");
            return modelAndView;}
        else {
            modelAndView.addObject("message", "Fields not completed");
            modelAndView.setViewName("book/register");
            return modelAndView;
        }
    };

    @RequestMapping(value = "/View", method = RequestMethod.GET)
    public ModelAndView view (@RequestParam(value = "id")long id){
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getBook(id);
        modelAndView.addObject("book", book);
        modelAndView.setViewName("book/view");
        return modelAndView;
    }
@RequestMapping(value = "/Edit{id}", method = RequestMethod.GET)
    public ModelAndView edit (@RequestParam(value = "id")long id) {
        ModelAndView modelAndView = new ModelAndView();
       Book book = bookService.getBook(id);
       modelAndView.setViewName("book/edit");
       modelAndView.addObject("book", book);
      return modelAndView;

    };

    @RequestMapping(value = "/Update/{id}", method = RequestMethod.POST)
    public ModelAndView update(Book book,
                               @PathVariable(value = "id") long id)
    {
        ModelAndView modelAndView = new ModelAndView();
        book.setId(id);
        bookService.updateBook(book);
        modelAndView.addObject("books", bookService.getBook(id));
        modelAndView.setViewName("book/view");
        return modelAndView;
    }
    @RequestMapping(value = "/Available_Books", method = RequestMethod.GET)
    public ModelAndView availablebooks(){
        ModelAndView modelAndView = new ModelAndView();
        List <Book> bookList = bookService.getAllBook();
        modelAndView.addObject("books", bookList);
        modelAndView.setViewName("book/availablebooks");
        return modelAndView;

    }
    @RequestMapping(value = "/Delete", method = RequestMethod.GET)
    public ModelAndView delete (@RequestParam(value = "id")long id){
        ModelAndView modelAndView = new ModelAndView();
        bookService.deleteBook(id);
        modelAndView.addObject("books", bookService.getAllBook());
        modelAndView.setViewName("book/availablebooks");
        return modelAndView;
    };

    @RequestMapping(value = "/My_Books", method = RequestMethod.GET)
    public ModelAndView mybooks () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book/mybooks");
        return modelAndView;
    };


    @RequestMapping(value = "/Searched_Books", method = RequestMethod.POST)
    public ModelAndView searchedbooks (@RequestParam(value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView();
if(name.length() != 0){
    List<Book> matchingBooks = bookService.searchBooksByName(name);
    modelAndView.addObject("books", matchingBooks);
    modelAndView.setViewName("book/search-results");
    return modelAndView;}
else{
    modelAndView.addObject("noInput", "Input Your Name!!");
    modelAndView.setViewName("book/mybooks");
    return modelAndView;
}

        };


    }





