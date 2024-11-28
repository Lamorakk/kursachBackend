package com.unik.kursach3.controller;

import com.unik.kursach3.entity.User;
import com.unik.kursach3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user/current")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            User user = (User) authentication.getPrincipal();
            return new User(user.getName(), user.getEmail(), user.getProfileImageUrl(), true);
        }
        return new User(null, null, null, false);
    }

//    @GetMapping("/user/current")
//    public ResponseEntity<?> getCurrentUser() {
//        Object userService;
//        User user = userService.getCurrentAuthenticatedUser();
//        if (user != null && userSessionService.isSessionActive(user.getId())) {
//            return ResponseEntity.ok(user);
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session expired");
//    }

    @PostMapping("/logout")
    public void logout() {
        // Логіка для виходу з системи (очистка сесії/токену)
        SecurityContextHolder.clearContext(); // Очищаємо контекст безпеки
    }
}

