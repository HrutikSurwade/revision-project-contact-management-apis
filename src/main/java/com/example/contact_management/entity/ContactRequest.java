package com.example.contact_management.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactRequest {

    @NotBlank(message = "Address is required!")
    private String address;

    @Email(message = "Invalid email format!")
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Name is required!")
    private String name;

    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number!")
    private String phone;

    @NotBlank(message = "Status is required!")
    private String status;
}