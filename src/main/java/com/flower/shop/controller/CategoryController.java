package com.flower.shop.controller;

import com.flower.shop.entity.Category;
import com.flower.shop.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/categoryList")
    public List<Category> categoryList(){
        return categoryService.findAll();
    }

    @PostMapping( "/saveCategory" )
    public Category saveCategory(@RequestBody Category  category) {
        return categoryService.save(category);
    }

}
