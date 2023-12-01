package com.opoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opoa.entites.Order;
import com.opoa.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/getAllOrder")
	public List<Order> getAllOrders() {
		return orderService.getAllOrder();
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.findOrder(id);
	}

	@PostMapping("/addOrder")
	public Order createOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}

	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		return orderService.updateOrder(id, order);
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
	}

}
