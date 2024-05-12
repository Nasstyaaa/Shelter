package com.example.KR_sem4.controller;

import com.example.KR_sem4.entity.Category;
import com.example.KR_sem4.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    private List<Category> getCategories(){
        return categoryService.getCategories();
    }
}
