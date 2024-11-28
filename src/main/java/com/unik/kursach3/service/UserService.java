package com.unik.kursach3.service;

import com.unik.kursach3.entity.User;
import com.unik.kursach3.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        // Hash the password before storing it in the database
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setVerified(false); // Assuming a user isn't verified initially
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        boolean passwordMatches = passwordEncoder.matches(password, user.getPasswordHash());
        System.out.println("Password matches: " + passwordMatches); // Debug log
        if (passwordMatches) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid email or password");
        }
    }

    private SecretKey getSigningKey() {
        // If you want to use a fixed secret from properties:
        // return new SecretKeySpec(jwtSecret.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS512.getJcaName());

        // Or generate a random key using the Key class
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateJwtToken(User user) {
        SecretKey key = getSigningKey();  // Use the generated secure key
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(key)  // Use the secure key here
                .compact();
    }

    public void initiatePasswordReset(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        String resetToken = UUID.randomUUID().toString();
        // Send `resetToken` to user's email (implementation omitted)
        System.out.println("Password reset token: " + resetToken);
    }
}
