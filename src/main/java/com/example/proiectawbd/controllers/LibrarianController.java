package com.example.proiectawbd.controllers;

import com.example.proiectawbd.domain.Book;
import com.example.proiectawbd.domain.Librarian;
import com.example.proiectawbd.services.BookService;
import com.example.proiectawbd.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LibrarianController {



    @Autowired
    LibrarianService librarianService;

    @RequestMapping("/librarian/list")
    public ModelAndView authorsList(){
        ModelAndView modelAndView = new ModelAndView("librarians");
        List<Librarian> librarians = librarianService.retrieveLibrarians();
        modelAndView.addObject("librarians",librarians);
        return modelAndView;
    }

    @GetMapping("/librarian/info/{id}")
    public String showById(@PathVariable int id, Model model) {
        model.addAttribute("librarian", librarianService.retrieveLibrarianById(id));
        return "librarianInfo";
    }

    @RequestMapping("/librarian/delete/{id}")
    public String deleteById(@PathVariable int id) {

        librarianService.deleteById(id);
        return "redirect:/librarian/list";
    }



    @RequestMapping("/librarian/new")
    public String newLibrarian(Model model) {
        model.addAttribute("librarian", new Librarian());
        return "librarianform";
    }

    @RequestMapping("/librarian/update/{librarianId}")
    public String updateLibrarian(@PathVariable int librarianId, Model model){

        //Librarian savedLibrarian = librarianService.retrieveLibrarianById(librarianId);

        model.addAttribute("librarian", librarianService.retrieveLibrarianById(librarianId));
        return "librarianUpdateForm";
    }


    @PostMapping("/librarian")
    public String saveOrUpdate(@ModelAttribute Librarian librarian){

        Librarian savedLibrarian = librarianService.saveLibrarian(librarian, librarian.getLibrary().getLibraryId());
        return "redirect:/librarian/list" ;
    }
    
    
}
