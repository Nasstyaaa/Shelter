package com.example.shelter.controller;

import com.example.shelter.dto.AnimalDTO;
import com.example.shelter.dto.UserDTO;
import com.example.shelter.entity.Request;
import com.example.shelter.entity.User;
import com.example.shelter.service.AnimalService;
import com.example.shelter.service.RequestService;
import com.example.shelter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final RequestService requestService;
    private final AnimalService animalService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> addUser(@RequestBody UserDTO user) {
        try {
            if (userService.usernameExists(user.getName())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with the same name already exists.");
        }
    }

    @PostMapping("/createRequest")
    public ResponseEntity<Request> createRequest(@RequestBody AnimalDTO animalDTO, Principal principal) {
        try {
            if (!animalService.animalNameExists(animalDTO.getName())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            Optional<User> userOptional = userService.findUserByName(principal.getName());
            User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));
            Request request = requestService.createRequest(animalDTO.getName(), user.getId());
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

}
