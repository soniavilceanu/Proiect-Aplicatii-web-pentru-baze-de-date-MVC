package com.example.proiectawbd.controllers;

import com.example.proiectawbd.domain.Author;
import com.example.proiectawbd.services.AuthorService;
import com.example.proiectawbd.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @RequestMapping("/author/list")
    public ModelAndView authorsList(){
        ModelAndView modelAndView = new ModelAndView("authors");
        List<Author> authors = authorService.retrieveAuthors();
        modelAndView.addObject("authors",authors);
        return modelAndView;
    }

    @GetMapping("/author/info/{id}")
    public String showById(@PathVariable int id, Model model) {
        model.addAttribute("author", authorService.retrieveAuthorById(id));
        return "authorInfo";
    }

    @RequestMapping("/author/update/{authorId}")
    public String updateAuthor(@PathVariable int authorId, Model model){

        model.addAttribute("author", authorService.retrieveAuthorById(authorId));
        return "authorUpdateForm";
    }

    @RequestMapping("/author/delete/{id}")
    public String deleteById(@PathVariable int id) {

        authorService.deleteById(id);
        return "redirect:/author/list";
    }






    @RequestMapping("/author/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authorform";
    }

    @PostMapping("/author")
    public String saveOrUpdate(@ModelAttribute Author author,  BindingResult bindingResult){
        Author savedAuthor = authorService.saveNewAuthor(author);

        if (bindingResult.hasErrors()){
            return "authorform";
        }
        return "redirect:/author/list" ;
    }





}
