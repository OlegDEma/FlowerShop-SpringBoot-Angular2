package com.flower.shop.service;

import com.flower.shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

     Product addProduct(Product Product);

     void removeProduct(Product product);

    void removeById(int id);

     Product findOne(int id);

     Product findByName(String name);

     void updateProduct(Product product);

     List<Product> findAll();

     List<Product> findAllSorted(Sort sort);

     Page<Product> findAllPageble(Pageable pageable);

    void saveImage(MultipartFile multipartFile);
}
