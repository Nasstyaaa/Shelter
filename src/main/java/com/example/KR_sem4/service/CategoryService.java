package com.example.KR_sem4.service;

import com.example.KR_sem4.entity.Category;
import com.example.KR_sem4.repository.CategoryRepository;
import com.example.KR_sem4.dto.CategoryDTO;
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
