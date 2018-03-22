package com.flower.shop.repository;

import com.flower.shop.entity.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDescriptionRepository extends JpaRepository<ProductDescription,Integer> {

    ProductDescription findByDescription(String description);
}
