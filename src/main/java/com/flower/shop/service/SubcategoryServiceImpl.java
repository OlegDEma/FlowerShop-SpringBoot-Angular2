package com.flower.shop.service;

import com.flower.shop.entity.Subcategory;
import com.flower.shop.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("subcategoryService")
@Transactional
public class SubcategoryServiceImpl implements SubcategoryService{

    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public void addSubcategory(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    public void removeSubcategory(Subcategory subcategory) {
        subcategoryRepository.delete(subcategory);
    }

    public void removeById(int id) {
        subcategoryRepository.delete(id);
    }

    public Subcategory findOne(int id) {
        return subcategoryRepository.findOne(id);
    }

    public Subcategory findByName(String name) {
        return subcategoryRepository.findByName(name);
    }

    public void updateSubcategory(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    public List<Subcategory> findAllSorted(Sort sort) {
        return subcategoryRepository.findAll(sort);
    }

    public Page<Subcategory> findAllPageble(Pageable pageable) {
        return subcategoryRepository.findAll(pageable);
    }
}
