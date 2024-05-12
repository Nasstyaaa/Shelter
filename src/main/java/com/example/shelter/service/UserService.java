package com.example.shelter.service;

import com.example.shelter.dto.UserDTO;
import com.example.shelter.entity.User;
import com.example.shelter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User addUser(UserDTO userDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(5);
        String hashpassword = passwordEncoder.encode(userDTO.getPassword());
        User user = User.builder()
                .name(userDTO.getName())
                .password(hashpassword)
                .role("USER")
                .build();
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserByName(String name){
        return userRepository.findByName(name);
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByName(username);
    }

}
