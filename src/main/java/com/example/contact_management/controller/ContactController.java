package com.example.contact_management.controller;

import com.example.contact_management.entity.Contact;
import com.example.contact_management.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/all")
    public ResponseEntity<Page<Contact>> getAllContacts (Pageable pageable) {

        return ResponseEntity.ok(
                contactService.getAllContacts(pageable)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getById (@PathVariable String id) {

        return ResponseEntity.ok(
                contactService.getContactById(id)
        );
    }

}