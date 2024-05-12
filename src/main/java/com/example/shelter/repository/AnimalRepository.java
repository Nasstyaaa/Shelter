package com.example.shelter.repository;

import com.example.shelter.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository  extends JpaRepository<Animal, Long> {
    List<Animal> findByCategoryId(Long id);
    Animal findAnimalByName(String name);
    boolean existsByName(String animalname);
}
