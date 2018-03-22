package com.flower.shop.service;

import com.flower.shop.entity.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ModelService {

    public Model addModel(Model model);

    public void removeModel(Model model);

    public void removeById(int id);

    public Model findOne(int id);

    public Model findByName(String name);

    public void updateModel(Model model);

    public List<Model> findAll();

    public List<Model> findAllSorted(Sort sort);

    public Page<Model> findAllPageble(Pageable pageable);
}
