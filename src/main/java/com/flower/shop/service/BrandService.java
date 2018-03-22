package com.flower.shop.service;

import com.flower.shop.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BrandService {
     Brand save(Brand brand);

     void removeBrand(Brand brand);

     void removeById(int id);

     Brand findOne(int id);

     Brand findByName(String name);

     void updateBrand(Brand brand);

     List<Brand> findAll();

     List<Brand> findAllSorted(Sort sort);

     Page<Brand> findAllPageble(Pageable pageable);

}
