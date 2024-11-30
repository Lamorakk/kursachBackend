package com.unik.kursach3.controller;

import com.unik.kursach3.entity.Project;
import com.unik.kursach3.payload.MessageResponse;
import com.unik.kursach3.service.ProjectService;
import com.unik.kursach3.service.UserService; // Додано для отримання поточного користувача
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    // Отримати проекти для поточного користувача
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Project> projects = projectService.getAllProjects(pageable);
        return ResponseEntity.ok(projects.getContent());
    }


    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }
}
