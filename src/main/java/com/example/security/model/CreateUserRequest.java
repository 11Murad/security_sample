package com.example.security.model;

import com.example.security.entity.role.Role;
import lombok.Builder;
import java.util.Set;

@Builder
public record CreateUserRequest(        String name,
        String username,
        String password,
        Set<Role> authorities) {
}
