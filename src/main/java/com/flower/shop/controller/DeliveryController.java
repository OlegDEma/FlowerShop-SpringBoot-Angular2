package com.flower.shop.controller;

import com.flower.shop.entity.Delivery;
import com.flower.shop.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class DeliveryController {

    private final Logger log = LoggerFactory.getLogger(DeliveryController.class);
    private DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/saveDelivery")
    public Delivery saveDelivery(@RequestBody Delivery delivery) {
        System.out.println(delivery);
        return deliveryService.addDelivery(delivery);
    }

    @PostMapping("/changeDelivery")
    public Delivery changeDelivery(@RequestBody Delivery delivery) {
        System.out.println(delivery);
        return deliveryService.addDelivery(delivery);
    }

    @GetMapping("/deleteDelivery/{id}")
    public Delivery deleteDelivery(@PathVariable int id) {
        System.out.println("DELETED");
        deliveryService.removeById(id);
        return deliveryService.findOne(id);
    }


    @GetMapping("/deliveryList")
    public List<Delivery> deliveryList() {
        return deliveryService.findAll();
    }

}
