package com.drdaza.login_spring_security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.drdaza.login_spring_security.users.domain.models.User;
import com.drdaza.login_spring_security.users.infraestructure.repositories.UserRepository;

@SpringBootApplication
public class LoginSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSpringSecurityApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User(null, "user",encoder.encode("password"),"ROLE_USER"));
			users.save(new User(null, "admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));
		};
	}
}
