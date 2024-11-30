package com.unik.kursach3.repository;

import com.unik.kursach3.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Пошук проектів за email користувача
    List<Project> findByUserEmail(String email);
}
