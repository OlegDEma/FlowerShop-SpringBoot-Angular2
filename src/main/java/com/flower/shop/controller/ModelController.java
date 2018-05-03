package com.flower.shop.controller;

import com.flower.shop.entity.Model;
import com.flower.shop.service.ModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class ModelController {

    private final Logger log = LoggerFactory.getLogger(ModelController.class);
    private ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/saveModel")
    public Model saveModel(@RequestBody Model model) {
        System.out.println(model);
        return modelService.addModel(model);
    }

    @GetMapping("/deleteModel/{id}")
    public Model deleteModel(@PathVariable int id) {
        modelService.removeById(id);
        return modelService.findOne(id);
    }

    @GetMapping("/modelList")
    public List<Model> modelList() {
        return modelService.findAll();
    }
}
