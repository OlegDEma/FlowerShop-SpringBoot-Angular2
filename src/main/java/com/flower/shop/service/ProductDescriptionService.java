package com.flower.shop.service;

import com.flower.shop.entity.ProductDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductDescriptionService {

     ProductDescription addProductDescription(ProductDescription productDescription);

     void removeProductDescription(ProductDescription productDescription);

     void removeDescriptionById(int id);

     ProductDescription findOne(int id);

     ProductDescription findByDescroption(String name);

     void updateProductDescription(ProductDescription productDescription);

     List<ProductDescription> findAll();

     List<ProductDescription> findAllSorted(Sort sort);

     Page<ProductDescription> findAllPageble(Pageable pageable);
}
