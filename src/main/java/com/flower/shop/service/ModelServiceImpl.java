package com.flower.shop.service;

import com.flower.shop.entity.Model;
import com.flower.shop.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("modelService")
@Transactional
public class ModelServiceImpl implements ModelService{

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    public Model addModel(Model model) {
        return modelRepository.save(model);
    }

    public void removeModel(Model model) {
        modelRepository.delete(model);
    }

    @Override
    public void removeById(int id) {
        modelRepository.delete(id);
    }

    public Model findOne(int id) {
        return modelRepository.findOne(id);
    }

    public Model findByName(String name) {
        return modelRepository.findByName(name);
    }

    public void updateModel(Model model) {
        modelRepository.save(model);
    }

    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    public List<Model> findAllSorted(Sort sort) {
        return modelRepository.findAll(sort);
    }

    public Page<Model> findAllPageble(Pageable pageable) {
        return modelRepository.findAll(pageable);
    }
}
