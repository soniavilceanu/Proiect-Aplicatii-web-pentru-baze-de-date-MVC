package com.example.proiectawbd.repositories;

import com.example.proiectawbd.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Publisher findPublisherByPublisherName(String publisherName);
}
