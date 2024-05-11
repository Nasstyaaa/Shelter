package com.example.KR_sem4.repository;

import com.example.KR_sem4.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository  extends JpaRepository<Animal, Long> {
    List<Animal> findByCategoryId(Long id);
    Animal findAnimalByName(String name);
    boolean existsByName(String animalname);
}
