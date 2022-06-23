package com.example.proiectawbd.controllers;


import com.example.proiectawbd.domain.Book;
import com.example.proiectawbd.domain.Librarian;
import com.example.proiectawbd.services.BookService;
import com.example.proiectawbd.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

//    @Autowired
//    BookService bookService;

    @Autowired
    LibrarianService librarianService;

    @GetMapping("/showLogInForm")
    public String showLogInForm(){ return "login"; }

//    @RequestMapping({"", "/", "/index"})
//    public ModelAndView booksList(){
//        ModelAndView modelAndView = new ModelAndView("books");
//        List<Book> books = bookService.retrieveBooks();
//        modelAndView.addObject("books",books);
//        return modelAndView;
//    }

    @RequestMapping({"", "/", "/index"})
    public ModelAndView librariansList(){
        ModelAndView modelAndView = new ModelAndView("librarians");
        List<Librarian> librarians = librarianService.retrieveLibrarians();
        modelAndView.addObject("librarians",librarians);
        return modelAndView;
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }


}