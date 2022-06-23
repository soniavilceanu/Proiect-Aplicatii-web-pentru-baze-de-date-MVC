package com.example.proiectawbd.services;

import com.example.proiectawbd.domain.Author;
import com.example.proiectawbd.domain.Book;
import com.example.proiectawbd.exceptions.NoAuthorFoundException;
import com.example.proiectawbd.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {


    private final BookDetailsRepository bookDetailsRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LibraryRepository libraryRepository;
    private final PublisherRepository publisherRepository;

    private final BookService bookService;


    public AuthorService(BookDetailsRepository bookDetailsRepository, BookRepository bookRepository, AuthorRepository authorRepository,
                         LibraryRepository libraryRepository, PublisherRepository publisherRepository, BookService bookService) {
        this.bookDetailsRepository = bookDetailsRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.libraryRepository = libraryRepository;
        this.publisherRepository = publisherRepository;
        this.bookService = bookService;
    }
    public Author saveNewAuthor(Author author){
        return authorRepository.save(author);
    }


    public Author retrieveAuthorByName(String authorName) {
        Author author = authorRepository.findAuthorByAuthorName(authorName);

        if(author != null) return author;
        else throw new NoAuthorFoundException("No author with this name was found");
    }



    public List<Author> retrieveAuthors() {
        return authorRepository.findAll();
    }

    public Author updateContact(int authorId, String contact) {

        Author author = authorRepository.findById(authorId).orElseThrow(() -> new NoAuthorFoundException("No author with this id was found"));

        author.setContact(contact);
        return authorRepository.save(author);

    }

    public Author updateAuthorName(int authorId, String authorName) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new NoAuthorFoundException("No author with this id was found"));

        author.setAuthorName(authorName);
        return authorRepository.save(author);

    }

    public List<Book> retrieveBooks(int authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new NoAuthorFoundException("No author with this id was found"));
        return author.getBookList();

    }

    public Author retrieveAuthorById(int authorId) {

        return authorRepository.findById(authorId).orElseThrow(() -> new NoAuthorFoundException("No author with this id was found"));
    }

    public void deleteById(int authorId){

        bookService.deleteBooksByAuthorId(authorId);

//        List<Book> books = bookService.retrieveBooksByAuthorId(authorId);
//        bookService.deleteManyById();

        retrieveAuthorById(authorId).setBookList(null);

        authorRepository.deleteById(authorId);

    }
}
