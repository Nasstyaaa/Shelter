package com.example.shelter.controller;

import com.example.shelter.entity.Request;
import com.example.shelter.entity.User;
import com.example.shelter.service.RequestService;
import com.example.shelter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestService requestService;
    private  final UserService userService;

    @GetMapping("/user")
    public List<Request> findByUserId(Principal principal){
        Optional<User> userOptional = userService.findUserByName(principal.getName());
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));
        return requestService.findByUserId(user.getId());
    }

}
