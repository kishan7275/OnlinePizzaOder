package com.opoa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.opoa.entites.Cart;

@Service
public interface CartService {

	List<Cart> getAllCarts();

    Cart getCartById(Long id);

    Cart createCart(Cart cart);

    Cart updateCart(Long id, Cart cart);

    void deleteCart(Long id);
}
