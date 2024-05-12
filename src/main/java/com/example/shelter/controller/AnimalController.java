package com.example.shelter.controller;

import com.example.shelter.entity.Animal;
import com.example.shelter.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@AllArgsConstructor
public class AnimalController {
    private final AnimalService animalService;
    @GetMapping
    public List<Animal> getAnimals(){
        return animalService.getAnimals();
    }

    @GetMapping("/{category_id}")
    public List<Animal> getAnimalByCategory(@PathVariable("category_id") Long id){
        return animalService.getAnimalByCategory(id);
    }
}
