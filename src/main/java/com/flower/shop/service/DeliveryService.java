package com.flower.shop.service;

import com.flower.shop.entity.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface DeliveryService {
     Delivery addDelivery(Delivery delivery);

     void removeDelivery(Delivery delivery);

     Delivery findOne(int id);

     void updateDelivery(Delivery Delivery);

     List<Delivery> findAll();

     List<Delivery> findAllSorted(Sort sort);

     Page<Delivery> findAllPageble(Pageable pageable);

     void removeById(int id);

}
