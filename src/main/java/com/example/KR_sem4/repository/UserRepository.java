package com.example.KR_sem4.repository;

import com.example.KR_sem4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String username);
    User findUserById(Long id);
    boolean existsByName(String username);
}
