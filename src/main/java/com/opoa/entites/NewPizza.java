package com.opoa.entites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class NewPizza {

	@Id
	private String id;
	@Column
	private String name;
	private int price;
	private int quantityAvailable;

		
	//Getters Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	@Override
	public String toString() {
		return "NewPizza [id=" + id + ", name=" + name + ", price=" + price + ", quantityAvailable=" + quantityAvailable
				+ "]";
	}

	public NewPizza(String id, String name, int price, int quantityAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantityAvailable = quantityAvailable;

	}

	public NewPizza() {
		super();
	}

}
