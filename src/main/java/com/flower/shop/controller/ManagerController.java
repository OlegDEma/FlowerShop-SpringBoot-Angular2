package com.flower.shop.controller;

import com.flower.shop.entity.Manager;
import com.flower.shop.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class ManagerController {
    private final Logger log = LoggerFactory.getLogger(ManagerController.class);
    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping( "/saveManager" )
    public Manager saveBrand(@RequestBody Manager  manager) {
        return managerService.save(manager);
    }

    @GetMapping("/deleteManager/{id}")
    public Manager deleteManager(@PathVariable int id){
        managerService.removeManager(managerService.findOne(id));
        return managerService.findOne(id);
    }

    @GetMapping("/managerList")
    public List<Manager> managerList(){
        return managerService.findAll();
    }


}
