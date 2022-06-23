package com.example.proiectawbd.repositories;

import com.example.proiectawbd.domain.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

    Librarian findAllByLibrarianName(String name);

}
