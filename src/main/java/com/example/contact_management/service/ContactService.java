package com.example.contact_management.service;

import com.example.contact_management.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {

    Page<Contact> getAllContacts(Pageable pageable);

    Contact getContactById(String id);
}