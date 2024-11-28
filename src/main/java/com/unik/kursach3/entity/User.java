package com.unik.kursach3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor // Default no-arg constructor for JPA
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(name = "password_hash")
    private String passwordHash;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean verified;

    @Column(name = "created_at", updatable = false, insertable = false)
    private java.sql.Timestamp createdAt;

    // Additional fields
    @Column
    private String name; // User's full name

    @Column(name = "profile_image_url")
    private String profileImageUrl; // URL for the user's profile image

    @Transient
    private boolean loggedIn; // This field won't be persisted, it's for controller logic

    // Constructor for setting email, password, and additional fields
    public User(String name, String email, String profileImageUrl, boolean loggedIn) {
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.loggedIn = loggedIn;
    }
    public User(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

}
