package com.example.proiectawbd;

import com.example.proiectawbd.domain.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CascadeTypeTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    @Order(1)
    public void saveBook() {
        Author author = new Author();
        author.setAuthorName("Author1");
        author.setContact("0788445566");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher1");

        BookDetails bookDetails = new BookDetails();
        bookDetails.setDescription("Book description 1");
        bookDetails.setNoOfPages(200);
        bookDetails.setPrice(30.50);

        Book book = new Book();
        book.setBookName("Book1");
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setBookDetails(bookDetails);

       Library library = new Library();
       library.setLocation("Iasi, str. Muresului");

        book.setLibraries(Arrays.asList(library));

        entityManager.persist(book);
        entityManager.persist(publisher);
        entityManager.persist(author);
        entityManager.persist(bookDetails);

        entityManager.flush();
        entityManager.clear();
    }


    @Test
    @Order(2)
    public void updateAuthor(){
        Book book = entityManager.find(Book.class, 2);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher2");

        Author author = book.getAuthor();
        author.setAuthorName("Author2");
        author.getBookList().forEach(booko -> {book.setPublisher(publisher);});
        entityManager.merge(author);

        entityManager.persist(book);
        entityManager.persist(publisher);
        entityManager.persist(author);

        entityManager.flush(); }


    @ParameterizedTest
    @Order(3)
    @ValueSource(ints = {1, 2})
    public void orphanRemoval(int id){
        Book book = entityManager.find(Book.class, id);
        book.setBookDetails(null);
        entityManager.persist(book);
        entityManager.flush();
    }


}