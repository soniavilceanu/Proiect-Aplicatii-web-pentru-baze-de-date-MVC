package com.example.proiectawbd.repository;


import com.example.proiectawbd.domain.Librarian;
import com.example.proiectawbd.repositories.LibrarianRepository;
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
public class LibrarianRepositoryTest {
    
    @Autowired
    private LibrarianRepository librarianRepository;

    @Test
    @Order(1)
    public void addLibrarian() {
        Librarian librarian = new Librarian();
        librarian.setLibrarianName("Librarian1");
        librarian.setEmail("lib1@gmail.com");
        librarianRepository.save(librarian);
    }


    @Test
    @Order(2)
    public void findByLibrarianName() {

        Librarian librarian = librarianRepository.findAllByLibrarianName("Librarian1");
        assertFalse(librarian == null);
        log.info("findByLibrarianName ...");
        List<Librarian> librarians = Arrays.asList(librarian);

        librarians.forEach(librarianoo -> log.info(librarian.getLibrarianName()));
    }




}
