package com.example.contact_management.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Document(collection = "contacts")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Contact {

    @NotBlank
    private String address;

    @CreatedDate
    private LocalDateTime createdAt;

    @NotBlank
    @Email
    @Indexed(unique = true)
    private String email;

    @Id
    private String id;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @NotBlank
    private String name;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    @NotBlank
    private String status;
}