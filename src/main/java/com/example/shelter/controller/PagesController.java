package com.example.shelter.controller;

import com.example.shelter.entity.User;
import com.example.shelter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class PagesController {
    private final UserService userService;
    @GetMapping
    public String welcomePage(){
        return "welcome";
    }
    @GetMapping("/home/redirectUser")
    public String redirectUser(Principal principal){
        Optional<User> userOptional = userService.findUserByName(principal.getName());
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));
        String name = user.getName();
        if(Objects.equals(user.getRole(), "ADMIN")){
            return "redirect:/home/admin";
        } else if (Objects.equals(user.getRole(), "USER")) {
            return "redirect:/home/user";
        }
        return name;
    }
    @GetMapping("/home/user")
    @PreAuthorize("hasAuthority('USER')")
    public String userPage(){
        return "userPage";
    }
    @GetMapping("/home/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminPage(){
        return "adminPage";
    }

    @GetMapping("/home/registry")
    public String allPage(){
        return "registration";
    }
}
