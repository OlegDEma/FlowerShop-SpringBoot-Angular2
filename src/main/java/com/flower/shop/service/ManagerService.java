package com.flower.shop.service;

import com.flower.shop.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ManagerService {

     Manager save(Manager manager);

     void removeManager(Manager manager);

     Manager findOne(int id);

     Manager findByName(String name);

     void updateManager(Manager manager);

     List<Manager> findAll();

     List<Manager> findAllSorted(Sort sort);

     Page<Manager> findAllPageble(Pageable pageable);



}
