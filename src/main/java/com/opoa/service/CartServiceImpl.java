package com.opoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opoa.entites.Cart;
import com.opoa.repository.CartRepository;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public Cart getCartById(Long id) {
		return cartRepository.findById(id).orElse(null);
	}

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Long id, Cart cart) {
		Cart existingCart = cartRepository.findById(id).orElse(null);

		if (existingCart != null) {
			existingCart.setQuantity(cart.getQuantity());
			// Update other properties as needed
			// ...

			cartRepository.save(existingCart);
		}

		return existingCart;
	}

	@Override
	public void deleteCart(Long id) {
		cartRepository.deleteById(id);
	}
}
