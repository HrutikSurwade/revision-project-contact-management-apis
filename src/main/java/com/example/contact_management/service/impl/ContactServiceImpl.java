package com.example.contact_management.service.impl;

import com.example.contact_management.config.PhoneProperties;
import com.example.contact_management.dto.contact.request.CreateContactRequest;
import com.example.contact_management.dto.contact.request.UpdateContactRequest;
import com.example.contact_management.dto.contact.response.ContactResponse;
import com.example.contact_management.entity.Contact;
import com.example.contact_management.exception.DuplicateResourceException;
import com.example.contact_management.exception.ResourceNotFoundException;
import com.example.contact_management.repository.ContactRepository;
import com.example.contact_management.service.ContactService;
import com.example.contact_management.util.mapper.ContactMapper;
import com.example.contact_management.util.phonenumber.PhoneNumberUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    @Transactional(readOnly = true)
    public Page<ContactResponse> getAllContacts(Pageable pageable) {

        return contactRepository.findAll(pageable)
                .map(ContactMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public ContactResponse getContactById(Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + id));

        return ContactMapper.toResponse(contact);
    }

    @Override
    public ContactResponse createContact(CreateContactRequest request) {

        if (contactRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        Contact contact = Contact.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .build();

        Contact saved = contactRepository.save(contact);

        return ContactMapper.toResponse(saved);
    }

    @Override
    public ContactResponse updateContact(Long id, UpdateContactRequest request) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + id));

        if (request.getEmail() != null &&
                !request.getEmail().equals(contact.getEmail()) &&
                contactRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        if (request.getFirstName() != null) {
            contact.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null) {
            contact.setLastName(request.getLastName());
        }

        if (request.getEmail() != null) {
            contact.setEmail(request.getEmail());
        }

        if (request.getPhoneNumber() != null) {
            contact.setPhoneNumber(request.getPhoneNumber());
        }

        if (request.getAddress() != null) {
            contact.setAddress(request.getAddress());
        }

        return ContactMapper.toResponse(contact);
    }

    @Override
    public void deleteContact(Long id) {

        if (!contactRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contact not found with id: " + id);
        }

        contactRepository.deleteById(id);
    }
}