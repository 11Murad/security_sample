package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class PrivateController {

    @GetMapping
    public String helloWordPrivate() {
        return "Hello World! from private endpoint";
    }
    @GetMapping("/user")
    public String helloWordUserPrivate() {
        return "Hello World! This is User";
    }
    @GetMapping("/admin")
    public String helloWordAdminPrivate() {
        return "Hello World! This is Admin";
    }

}
