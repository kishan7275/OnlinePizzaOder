package com.opoa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opoa.entites.Cart;
import com.opoa.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/getAllCart")
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
		Cart cart = cartService.getCartById(id);
		return cart != null ? ResponseEntity.ok(cart) : ResponseEntity.notFound().build();
	}

	@PostMapping("/addCart")
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		Cart createdCart = cartService.createCart(cart);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
		Cart updatedCart = cartService.updateCart(id, cart);
		return updatedCart != null ? ResponseEntity.ok(updatedCart) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
		return ResponseEntity.noContent().build();
	}
}
