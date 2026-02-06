package com.example.contact_management.repository;

import com.example.contact_management.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

    boolean existsByEmail(String email);

    Page<Contact> findByStatus(String status, Pageable pageable);
}