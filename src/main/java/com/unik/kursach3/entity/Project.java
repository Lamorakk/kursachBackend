package com.unik.kursach3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "responsible_dev")
    private String responsibleDev;

    @Column(name = "progress", columnDefinition = "INT DEFAULT 0")
    private int progress;

    @Column(name = "user_email")
    private String userEmail; // Email користувача, який є відповідальним
}
