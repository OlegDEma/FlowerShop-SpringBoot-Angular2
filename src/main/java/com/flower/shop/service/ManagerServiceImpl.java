package com.flower.shop.service;

import com.flower.shop.entity.Manager;
import com.flower.shop.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @Override
    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    public void removeManager(Manager manager) {
        managerRepository.delete(manager);
    }

    public Manager findOne(int id) {
        return managerRepository.findOne(id);
    }

    public Manager findByName(String name) {
        return managerRepository.findByName(name);
    }

    public void updateManager(Manager manager) {
        managerRepository.save(manager);
    }

    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    public List<Manager> findAllSorted(Sort sort) {
        return managerRepository.findAll(sort);
    }

    public Page<Manager> findAllPageble(Pageable pageable) {
        return managerRepository.findAll(pageable);
    }
}
