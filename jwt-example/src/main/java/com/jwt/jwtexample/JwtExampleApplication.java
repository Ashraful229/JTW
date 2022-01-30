package com.jwt.jwtexample;

import com.jwt.jwtexample.entity.User;
import com.jwt.jwtexample.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtExampleApplication {
	@Autowired
	private UserRepo userRepo;

	@PostConstruct
	public void initUsers()
	{
		List<User> userList= Stream.of(
				new User(101,"emon","1234","emon@gmail.com"),
				new User(102,"emon2","1234","emon2@gmail.com"),
				new User(103,"emon3","1234","emon3@gmail.com")
		).collect(Collectors.toList());
		userRepo.saveAll(userList);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtExampleApplication.class, args);
	}

}
