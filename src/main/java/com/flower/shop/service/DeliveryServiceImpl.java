package com.flower.shop.service;

import com.flower.shop.entity.Delivery;
import com.flower.shop.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("deliveryService")
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery addDelivery(Delivery delivery) {
         return deliveryRepository.save(delivery);
    }

    public void removeDelivery(Delivery delivery) {
        deliveryRepository.delete(delivery);
    }

    public Delivery findOne(int id) {
        return deliveryRepository.findOne(id);
    }


    public void updateDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    public List<Delivery> findAllSorted(Sort sort) {
        return deliveryRepository.findAll(sort);
    }

    public Page<Delivery> findAllPageble(Pageable pageable) {
        return deliveryRepository.findAll(pageable);
    }

    public void removeById(int id) {
        deliveryRepository.delete(id);
    }
}
