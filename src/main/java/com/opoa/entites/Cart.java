package com.opoa.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {

	@Id
	private Long id;
	
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + "]";
	}
	

	public Cart(Long id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public Cart() {
		super();
	}

}
