package com.example.security.model;

public record AuthRequest(
        String username,
        String password
) {
}
