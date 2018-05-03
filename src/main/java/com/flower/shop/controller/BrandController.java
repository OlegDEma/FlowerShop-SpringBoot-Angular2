package com.flower.shop.controller;

import com.flower.shop.entity.Brand;
import com.flower.shop.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class BrandController {

    private final Logger log = LoggerFactory.getLogger(BrandController.class);
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping( "/saveBrand" )
    public Brand saveBrand(@RequestBody Brand brand) {
        System.out.println(brand);
        return brandService.save(brand);
    }

    @PostMapping( "/changeBrand" )
    public Brand changeBrand(@RequestBody Brand brand) {
        System.out.println(brand);
        return brandService.save(brand);
    }

    @GetMapping("/brandList")
    public List<Brand> brandList(){
        return brandService.findAll();
    }


    @GetMapping("/deleteBrand/{id}")
    public Brand deleteBrand(@PathVariable int id){
        Brand brand = brandService.findOne(id);
        brandService.removeById(id);
        return brand;
    }


}
