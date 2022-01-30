package com.jwt.jwtexample.repository;

import com.jwt.jwtexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
