package com.example.shelter.service;


import com.example.shelter.entity.Animal;
import com.example.shelter.entity.Category;
import com.example.shelter.repository.AnimalRepository;
import com.example.shelter.dto.AnimalDTO;
import com.example.shelter.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final CategoryRepository categoryRepository;

    public Animal addAnimal(AnimalDTO animalsDTO){
        Category category = categoryRepository.findCategoryByName(animalsDTO.getCategory());
       Animal animal = Animal.builder()
               .name(animalsDTO.getName())
               .breed(animalsDTO.getBreed())
               .category(category)
               .isAvailable(true)
               .build();
        return animalRepository.save(animal);
    }

    public List<Animal> getAnimals(){
        return animalRepository.findAll();
    }

    public List<Animal> getAnimalByCategory(Long id){
        return animalRepository.findByCategoryId(id);
    }

    public boolean animalNameExists(String animalname) {
        return animalRepository.existsByName(animalname);
    }

}
