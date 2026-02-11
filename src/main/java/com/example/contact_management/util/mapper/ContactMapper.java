package com.example.contact_management.util.mapper;

import com.example.contact_management.dto.contact.response.ContactResponse;
import com.example.contact_management.entity.Contact;

public class ContactMapper {

    private ContactMapper() {
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static ContactResponse toResponse(Contact contact) {

        return ContactResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phoneNumber(contact.getPhoneNumber())
                .address(contact.getAddress())
                .createdAt(contact.getCreatedAt())
                .updatedAt(contact.getUpdatedAt())
                .build();
    }
}