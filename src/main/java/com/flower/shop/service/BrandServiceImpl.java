package com.flower.shop.service;

import com.flower.shop.entity.Brand;
import com.flower.shop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public void removeBrand(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public void removeById(int id) {
        brandRepository.delete(id);
    }

    public Brand findOne(int id) {
        return brandRepository.findOne(id);
    }

    public Brand findByName(String name) {
        return brandRepository.findByName(name);
    }

    public void updateBrand(Brand brand) {
        brandRepository.save(brand);
    }


    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public List<Brand> findAllSorted(Sort sort) {
        return brandRepository.findAll(sort);
    }

    public Page<Brand> findAllPageble(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

}
