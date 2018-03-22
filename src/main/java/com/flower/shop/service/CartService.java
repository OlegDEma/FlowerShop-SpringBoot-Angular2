package com.flower.shop.service;

import com.flower.shop.entity.Cart;

import java.util.List;

public interface CartService {
    public void addCart(Cart cart);

    public void update(Cart cart);

    public void  remove(Cart cart);

    public void removeById(int id);

    public List<Cart> findAll();

    public Cart findOne(int id);

    public Cart findByName(String name);

}
