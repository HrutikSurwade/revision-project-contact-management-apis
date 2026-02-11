package com.example.contact_management.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Table(
        name = "contacts",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_contact_email", columnNames = "email")
        },
        indexes = {
                @Index(name = "contact_email_index", columnList = "email"),
                @Index(name = "contact_phone_index", columnList = "phone_number")
        }
)
public class Contact extends BaseEntity {

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 20)
    private String status;
}