package com.example.KR_sem4.controller;

import com.example.KR_sem4.entity.Animal;
import com.example.KR_sem4.service.AnimalService;
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
