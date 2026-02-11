package com.example.contact_management.repository;

import com.example.contact_management.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByEmail(String email);

    Optional<Contact> findByEmail(String email);

    Page<Contact> findByStatus(String status, Pageable pageable);
}