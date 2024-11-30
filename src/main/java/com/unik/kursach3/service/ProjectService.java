package com.unik.kursach3.service;

import com.unik.kursach3.entity.Project;
import com.unik.kursach3.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Отримати всі проекти конкретного користувача
    public List<Project> getProjectsByUserEmail(String email) {
        return projectRepository.findByUserEmail(email); // Потрібно реалізувати цей метод у репозиторії
    }

    public Page<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }


    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
