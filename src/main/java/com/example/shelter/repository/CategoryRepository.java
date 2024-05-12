package com.example.shelter.repository;

import com.example.shelter.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String id);
    boolean existsByName(String name);
}
