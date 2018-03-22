package com.flower.shop.service;

import com.flower.shop.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface SaleService {

     void addSale(Sale sale);

     void removeSale(Sale sale);

     void removeById(int id);

     Sale findOne(int id);

     void updateSale(Sale sale);

     List<Sale> findAll();

     List<Sale> findAllSorted(Sort sort);

     Page<Sale> findAllPageble(Pageable pageable);
}
