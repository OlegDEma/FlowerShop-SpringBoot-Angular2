package com.flower.shop.controller;

import com.flower.shop.entity.ProductDescription;
import com.flower.shop.service.ProductDescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class ProductDescriptionController {

    private final Logger log = LoggerFactory.getLogger(ProductDescriptionController.class);
    private ProductDescriptionService productDescriptionService;

    public ProductDescriptionController(ProductDescriptionService productDescriptionService) {
        this.productDescriptionService = productDescriptionService;
    }

    @PostMapping("/saveDescription")
    public ProductDescription saveDescription(@RequestBody ProductDescription productDescription) {
        System.out.println(productDescription);
        return productDescriptionService.addProductDescription(productDescription);
    }

    @GetMapping("/deleteDescription/{id}")
    public ProductDescription deleteDescription(@PathVariable int id) {
        System.out.println("DELETED");
        productDescriptionService.removeDescriptionById(id);
        return productDescriptionService.findOne(id);
    }

    @GetMapping("/descriptionList")
    public List<ProductDescription> descriptionList() {
        return productDescriptionService.findAll();
    }
}
