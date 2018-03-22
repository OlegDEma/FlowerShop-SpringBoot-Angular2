package com.flower.shop.service;

import com.flower.shop.entity.Cart;
import com.flower.shop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService  {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }

    public void update(Cart cart) {
        cartRepository.save(cart);
    }

    public void remove(Cart cart) {
        cartRepository.delete(cart);
    }

    public void removeById(int id) {
        cartRepository.delete(id);
    }

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart findOne(int id) {
        return cartRepository.findOne(id);
    }

    public Cart findByName(String name) {
        return cartRepository.findByname(name);
    }
}
