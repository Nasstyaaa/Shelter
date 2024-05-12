package com.example.shelter.repository;

import com.example.shelter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String username);
    User findUserById(Long id);
    boolean existsByName(String username);
}
