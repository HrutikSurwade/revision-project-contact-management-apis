package com.example.contact_management.controller;

import com.example.contact_management.dto.contact.request.CreateContactRequest;
import com.example.contact_management.dto.contact.request.UpdateContactRequest;
import com.example.contact_management.dto.contact.response.ContactResponse;
import com.example.contact_management.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponse createContact(
            @Valid @RequestBody CreateContactRequest request) {

        return contactService.createContact(request);
    }

    @GetMapping("/{id}")
    public ContactResponse getContactById(@PathVariable Long id) {

        return contactService.getContactById(id);
    }

    @GetMapping
    public Page<ContactResponse> getAllContacts(Pageable pageable) {

        return contactService.getAllContacts(pageable);
    }

    @PutMapping("/{id}")
    public ContactResponse updateContact(
            @PathVariable Long id,
            @Valid @RequestBody UpdateContactRequest request) {

        return contactService.updateContact(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id) {

        contactService.deleteContact(id);
    }
}