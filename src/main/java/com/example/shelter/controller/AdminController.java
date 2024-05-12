package com.example.shelter.controller;

import com.example.shelter.entity.Animal;
import com.example.shelter.entity.Category;
import com.example.shelter.entity.Request;
import com.example.shelter.entity.User;
import com.example.shelter.service.AnimalService;
import com.example.shelter.service.CategoryService;
import com.example.shelter.dto.AnimalDTO;
import com.example.shelter.dto.CategoryDTO;
import com.example.shelter.service.RequestService;
import com.example.shelter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AnimalService animalService;

    private final CategoryService categoryService;

    private final RequestService requestService;

    private final UserService userService;

    @PostMapping("/animal")
    public ResponseEntity<Animal> addAnimal(@RequestBody AnimalDTO animalsDTO) {
        try {
            if (animalService.animalNameExists(animalsDTO.getName())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            if (!categoryService.categoryNameExists(animalsDTO.getCategory())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(animalService.addAnimal(animalsDTO), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict");
        }
    }
    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            if (categoryService.categoryNameExists(categoryDTO.getName())){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(categoryService.addCategory(categoryDTO), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/approveRequest/{id}")
    public ResponseEntity<Request> approveRequest(@PathVariable("id") Long id){
        Request request = requestService.findRequestById(id);
        if (Objects.equals(request.getStatus(), "NEW")) {
            requestService.approveRequest(id);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/rejectRequest/{id}")
    public ResponseEntity<Request> rejectRequest(@PathVariable("id") Long id){
        Request request = requestService.findRequestById(id);
        if (Objects.equals(request.getStatus(), "NEW")) {
            requestService.rejectRequest(id);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/requests")
    public List<Request> getRequests(){
        return requestService.getRequests();
    }

    @GetMapping("/requests/{status}")
    public List<Request> getRequestsByStatus(@PathVariable("status") String status){
        return requestService.findRequestByStatus(status);
    }
}
