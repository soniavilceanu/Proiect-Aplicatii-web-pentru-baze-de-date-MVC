package com.example.proiectawbd.repositories;


import com.example.proiectawbd.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookByBookName(String name);

    void deleteByBookIdIn(List<Integer> ids);
}