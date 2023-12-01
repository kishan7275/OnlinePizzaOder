package com.opoa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opoa.entites.Order;
import com.opoa.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(long id) {
		// TODO Auto-generated method stub
		Order od = findOrder(id);
		orderRepository.deleteById(od.getOrderId());

	}

	@Override
	public Order findOrder(long id) {
		// TODO Auto-generated method stub
		Optional<Order> opt = orderRepository.findById(id);
		return opt.get();
	}

	@Override
	public Order updateOrder(Long id, Order order) {
		Order ord = orderRepository.findById(id).get();
		ord.setOrderDate(order.getOrderDate());
		ord.setOrderNumber(order.getOrderNumber());
		ord.setOrderStatus(order.getOrderStatus());
		return orderRepository.save(ord);
	}
}
