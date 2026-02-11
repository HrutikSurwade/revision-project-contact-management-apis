package com.example.contact_management.service;

import com.example.contact_management.dto.contact.request.CreateContactRequest;
import com.example.contact_management.dto.contact.request.UpdateContactRequest;
import com.example.contact_management.dto.contact.response.ContactResponse;
import com.example.contact_management.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {

    Page<ContactResponse> getAllContacts(Pageable pageable);

    ContactResponse getContactById(Long id);

    ContactResponse createContact(CreateContactRequest request);

    ContactResponse updateContact(Long id, UpdateContactRequest request);

    void deleteContact(Long id);
}