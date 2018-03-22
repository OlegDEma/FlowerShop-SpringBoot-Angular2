package com.flower.shop.service;

import com.flower.shop.entity.Category;
import com.flower.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category save(Category category) {
         return categoryRepository.save(category);
    }

    public void removeCategory(Category category) {
        categoryRepository.delete(category);
    }

    public Category findOne(int id) {
        return categoryRepository.findOne(id);
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findAllSorted(Sort sort) {
        return categoryRepository.findAll(sort);
    }
}
