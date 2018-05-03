package com.flower.shop.controller;

import com.flower.shop.entity.Product;
import com.flower.shop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/deleteProduct/{id}")
    public Product deleteProduct(@PathVariable int id){
        productService.removeById(id);
        return productService.findOne(id);
    }

    @PostMapping( "/saveProduct" )
    public Product saveProduct(@RequestBody Product  product) {
        return productService.addProduct(product);
    }

    @GetMapping("/productList")
    public List<Product> productList(){
        return productService.findAll();
    }

    @PostMapping("/saveImageForProduct")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        productService.saveImage(file);
        return "ok";
    }
}
