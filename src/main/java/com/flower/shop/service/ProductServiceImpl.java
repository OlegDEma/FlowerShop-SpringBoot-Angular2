package com.flower.shop.service;

import com.flower.shop.entity.Product;
import com.flower.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

    public void removeById(int id) {
        productRepository.delete(id);
    }

    public Product findOne(int id) {
        return productRepository.findOne(id);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllSorted(Sort sort) {
        return productRepository.findAll(sort);
    }

    public Page<Product> findAllPageble(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public void saveImage(MultipartFile multipartFile) {

        String UPLOADED_FOLDER = "E:/java/spring-angular2-tasks-master/src/main/frontend/src/assets/images/products/";

        if (multipartFile.isEmpty()) {

        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
            Path write = Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        String path = System.getProperty("catalina.home") + "/resources/" + product.getName() + "/"
//                + multipartFile.getOriginalFilename();
//
//        product.setImage("resources/" + product.getName() + "/" + multipartFile.getOriginalFilename());
//
//        File file = new File(path);
//
//        try {
//            file.mkdirs();
//            try {
//                FileUtils.cleanDirectory(
//                        new File(System.getProperty("catalina.home") + "/resources/" + product.getName() + "/"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            multipartFile.transferTo(file);
//        } catch (IOException e) {
//            System.out.println("error with file");
//        }
    }

//    public void saveImageForProduct( int id , MultipartFile multipartFile) {
//
//        String UPLOADED_FOLDER = "E://temp//";
//
//        Product product = productRepository.findOne(id);
//
//        if (multipartFile.isEmpty()) {
//
//        }
//
//
//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = multipartFile.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
//            Path write = Files.write(path, bytes);
//
//            product.setImage(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        String path = System.getProperty("catalina.home") + "/resources/" + product.getName() + "/"
////                + multipartFile.getOriginalFilename();
////
////        product.setImage("resources/" + product.getName() + "/" + multipartFile.getOriginalFilename());
////
////        File file = new File(path);
////
////        try {
////            file.mkdirs();
////            try {
////                FileUtils.cleanDirectory(
////                        new File(System.getProperty("catalina.home") + "/resources/" + product.getName() + "/"));
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////            multipartFile.transferTo(file);
////        } catch (IOException e) {
////            System.out.println("error with file");
////        }
//    }
}
