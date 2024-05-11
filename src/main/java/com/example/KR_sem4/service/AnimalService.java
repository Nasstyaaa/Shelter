package com.example.KR_sem4.service;


import com.example.KR_sem4.entity.Animal;
import com.example.KR_sem4.entity.Category;
import com.example.KR_sem4.repository.AnimalRepository;
import com.example.KR_sem4.dto.AnimalDTO;
import com.example.KR_sem4.repository.CategoryRepository;
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
               .availability(true)
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
