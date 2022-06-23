package com.example.proiectawbd.services;


import com.example.proiectawbd.domain.Publisher;
import com.example.proiectawbd.exceptions.NoPublisherFoundException;
import com.example.proiectawbd.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {



    private final BookDetailsRepository bookDetailsRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final LibraryRepository libraryRepository;
    private final AuthorRepository authorRepository;

    private final BookService bookService;


    public PublisherService(BookDetailsRepository bookDetailsRepository, BookRepository bookRepository, PublisherRepository publisherRepository,
                            LibraryRepository libraryRepository, AuthorRepository authorRepository, BookService bookService) {
        this.bookDetailsRepository = bookDetailsRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.libraryRepository = libraryRepository;
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }
    public Publisher saveNewPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }


    public Publisher retrievePublisherByName(String PublisherName) {
        Publisher publisher = publisherRepository.findPublisherByPublisherName(PublisherName);

        if(publisher != null) return publisher;
        else throw new NoPublisherFoundException("No publisher with this name was found");
    }



    public List<Publisher> retrievePublishers() {
        return publisherRepository.findAll();
    }

    public Publisher updatePublisherName(int publisherId, String publisherName) {

        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow(() -> new NoPublisherFoundException("No publisher with this id was found"));
        publisher.setPublisherName(publisherName);
        return publisherRepository.save(publisher);
    }

    public Publisher retrievePublisherById(int publisherId) {

        return publisherRepository.findById(publisherId).orElseThrow(() -> new NoPublisherFoundException("No publisher with this id was found"));
    }

    public void deleteById(int publisherId){
        publisherRepository.deleteById(publisherId);

    }
}
