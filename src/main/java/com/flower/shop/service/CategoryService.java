package com.flower.shop.service;

import com.flower.shop.entity.Category;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CategoryService {

    public Category save(Category category);

    public void removeCategory(Category category);

    public Category findOne(int id);

    public Category findByName(String name);

    public void updateCategory(Category category);

    public List<Category> findAll();

    public List<Category> findAllSorted(Sort sort);
}
