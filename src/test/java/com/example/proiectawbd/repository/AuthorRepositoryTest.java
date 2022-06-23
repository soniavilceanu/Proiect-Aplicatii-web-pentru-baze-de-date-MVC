package com.example.proiectawbd.repository;


import com.example.proiectawbd.domain.Author;
import com.example.proiectawbd.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
@Slf4j
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Order(1)
    public void addAuthor() {
        Author author = new Author();
        author.setAuthorName("Author1");
        author.setContact("0788445566");

        authorRepository.save(author);
    }


    @Test
    @Order(2)
    public void findAuthorByAuthorName() {

        Author author = authorRepository.findAuthorByAuthorName("Author1");
        assertFalse(author == null);
        log.info("findAuthorByAuthorName ...");
        List<Author> authors = Arrays.asList(author);

        authors.forEach(authoroo -> log.info(author.getAuthorName()));
    }




}
