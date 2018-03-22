package com.flower.shop.service;

import com.flower.shop.entity.Sale;
import com.flower.shop.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("saleService")
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void addSale(Sale sale) {
        saleRepository.save(sale);
    }

    public void removeSale(Sale sale) {
        saleRepository.delete(sale);
    }

    public void removeById(int id) {
        saleRepository.delete(id);
    }

    public Sale findOne(int id) {
        return saleRepository.findOne(id);
    }

    public void updateSale(Sale sale) {
        saleRepository.save(sale);
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public List<Sale> findAllSorted(Sort sort) {
        return saleRepository.findAll(sort);
    }

    public Page<Sale> findAllPageble(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }
}
