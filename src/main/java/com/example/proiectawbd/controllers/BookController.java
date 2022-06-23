package com.example.proiectawbd.controllers;

import com.example.proiectawbd.domain.Author;
import com.example.proiectawbd.domain.Book;
import com.example.proiectawbd.domain.Librarian;
import com.example.proiectawbd.services.AuthorService;
import com.example.proiectawbd.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {


    @Autowired
    BookService bookService;

    @RequestMapping("/book/list")
    public ModelAndView booksList(){
        ModelAndView modelAndView = new ModelAndView("books");
        List<Book> books = bookService.retrieveBooks();
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @GetMapping("/book/info/{id}")
    public String showById(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.retrieveBookById(id));
        return "bookInfo";
    }

    @RequestMapping("/book/delete/{id}")
    public String deleteById(@PathVariable int id) {

        bookService.deleteById(id);
        return "redirect:/book/list";
    }



    @RequestMapping("/book/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "bookform";
    }

    @RequestMapping("/book/update/{bookId}")
    public String updateBook(@PathVariable int bookId, Model model){

        model.addAttribute("book", bookService.retrieveBookById(bookId));
        return "bookUpdateForm";
    }


    @PostMapping("/book")
    public String saveOrUpdate(@ModelAttribute Book book,  BindingResult bindingResult){
        Book savedBook = bookService.saveNewBook(book);

        if (bindingResult.hasErrors()){
            return "bookform";
        }
        return "redirect:/book/list" ;
    }


//
//    @PostMapping("/book")
//    public String saveOrUpdate(@ModelAttribute Book book){
//
//        Book savedBook = bookService.saveBook(book, book.getBookDetails().getBookDetailsId(), book.getAuthor().getAuthorId(), book.getPublisher().getPublisherId());
//        return "redirect:/book/list" ;
//    }


}
