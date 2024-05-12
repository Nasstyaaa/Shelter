package com.example.KR_sem4.repository;

import com.example.KR_sem4.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String id);
    boolean existsByName(String name);
}
