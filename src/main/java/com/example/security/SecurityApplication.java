package com.example.security;
import com.example.security.entity.role.Role;
import com.example.security.model.CreateUserRequest;
import com.example.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {
	private final UserService userService;
    public SecurityApplication(UserService userService) {
        this.userService = userService;
    }
    public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}
	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("Emin")
				.username("emin")
				.password("pass")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request);
		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("Murad")
				.username("murad")
				.password("pass")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request2);
	}
}
