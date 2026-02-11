package com.example.contact_management.dto.contact.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ContactResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String address;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}