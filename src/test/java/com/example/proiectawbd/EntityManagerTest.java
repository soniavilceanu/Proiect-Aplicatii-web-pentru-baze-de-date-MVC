package com.example.proiectawbd;

import com.example.proiectawbd.domain.Librarian;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    @Order(1)
    public void findLibrarian() {
        Librarian librarianFound = entityManager.find(Librarian.class, 1);
        assertEquals(librarianFound.getLibrarianName(), "Librarian1");
    }


    @Test
    @Order(2)
    public void findEmail() {
        Librarian librarianFound = entityManager.find(Librarian.class, 1);
        assertEquals(librarianFound.getEmail(), "lib1@gmail.com");
    }

    @Test
    @Order(3)
    public void updatelibrarian() {
        Librarian librarianFound = entityManager.find(Librarian.class, 1);
        librarianFound.setEmail("email22@gmail.com"); entityManager.persist(librarianFound); entityManager.flush();
    }

}
