package com.example.proiectawbd.repositories;

import com.example.proiectawbd.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findAuthorByAuthorName(String name);

}
