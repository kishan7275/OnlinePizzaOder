package com.opoa.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@Column
	private String orderNumber;
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderDate;
	@Column
	private String orderStatus;

	// Mappings
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "NewPizza", cascade = CascadeType.ALL)
//	private List<NewPizza> pizza= new ArrayList<>();

	

	// Getters Setters
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderStatus=" + orderStatus + "]";
	}

	public Order(Long orderId, String orderNumber, LocalDate orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public Order() {
		super();
	}

}
