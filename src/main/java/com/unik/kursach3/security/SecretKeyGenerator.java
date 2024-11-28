package com.unik.kursach3.security;

import java.security.SecureRandom;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 32 bytes = 256 bits
        secureRandom.nextBytes(key);

        // Convert to hexadecimal representation
        StringBuilder hexKey = new StringBuilder();
        for (byte b : key) {
            hexKey.append(String.format("%02x", b));
        }

        System.out.println("Generated Secret Key: " + hexKey.toString());
    }
}

