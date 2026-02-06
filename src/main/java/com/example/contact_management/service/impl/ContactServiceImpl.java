package com.example.contact_management.service.impl;

import com.example.contact_management.entity.Contact;
import com.example.contact_management.repository.ContactRepository;
import com.example.contact_management.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Page<Contact> getAllContacts (Pageable pageable) {

        return contactRepository.findAll(pageable);
    }

    @Override
    public Contact getContactById(String id) {

        return contactRepository.findById(id).orElse(null);
    }
}