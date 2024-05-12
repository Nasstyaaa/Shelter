package com.example.shelter.service;

import com.example.shelter.entity.Category;
import com.example.shelter.repository.CategoryRepository;
import com.example.shelter.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category addCategory(CategoryDTO categoryDTO){
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(category);
    }
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public boolean categoryNameExists(String name) {
        return categoryRepository.existsByName(name);
    }
}
