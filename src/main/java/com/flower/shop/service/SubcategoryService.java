package com.flower.shop.service;

import com.flower.shop.entity.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface SubcategoryService {

     void addSubcategory(Subcategory subcategory);

     void removeSubcategory(Subcategory subcategory);

     void removeById(int id);

     Subcategory findOne(int id);

     Subcategory findByName(String name);

     void updateSubcategory(Subcategory subcategory);

     List<Subcategory> findAll();

     List<Subcategory> findAllSorted(Sort sort);

     Page<Subcategory> findAllPageble(Pageable pageable);
}
