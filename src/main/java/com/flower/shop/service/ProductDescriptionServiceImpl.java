package com.flower.shop.service;

import com.flower.shop.entity.ProductDescription;
import com.flower.shop.repository.ProductDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("productDescriptionService")
@Transactional
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    private final ProductDescriptionRepository productDescriptionRepository;

    @Autowired
    public ProductDescriptionServiceImpl(ProductDescriptionRepository productDescriptionRepository) {
        this.productDescriptionRepository = productDescriptionRepository;
    }

    public ProductDescription addProductDescription(ProductDescription productDescription) {
       return productDescriptionRepository.save(productDescription);
    }

    public void removeProductDescription(ProductDescription productDescription) {
        productDescriptionRepository.delete(productDescription);
    }

    public void removeDescriptionById(int id) {
        productDescriptionRepository.delete(id);
    }

    public ProductDescription findOne(int id) {
        return productDescriptionRepository.findOne(id);
    }

    public ProductDescription findByDescroption(String description) {
        return productDescriptionRepository.findByDescription(description);
    }

    public void updateProductDescription(ProductDescription productDescription) {
        productDescriptionRepository.save(productDescription);
    }

    public List<ProductDescription> findAll() {
        return productDescriptionRepository.findAll();
    }

    public List<ProductDescription> findAllSorted(Sort sort) {
        return productDescriptionRepository.findAll(sort);
    }

    public Page<ProductDescription> findAllPageble(Pageable pageable) {
        return productDescriptionRepository.findAll(pageable);
    }
}
