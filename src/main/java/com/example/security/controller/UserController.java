package com.example.security.controller;
import com.example.security.entity.User;
import com.example.security.model.AuthRequest;
import com.example.security.model.CreateUserRequest;
import com.example.security.service.JwtService;
import com.example.security.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the protected endpoint!";
    }

    @PostMapping("/signup")
    public User addUser(@RequestBody CreateUserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (request.username(), request.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.username());
        }
        else throw new UsernameNotFoundException("Invalid username {} "+ request.username());
    }


}
