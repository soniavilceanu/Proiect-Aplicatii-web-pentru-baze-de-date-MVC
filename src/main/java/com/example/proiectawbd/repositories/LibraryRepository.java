package com.example.proiectawbd.repositories;


import com.example.proiectawbd.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    Library findAllByLocation(String location);
}
