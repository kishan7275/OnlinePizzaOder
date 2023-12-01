package com.opoa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.opoa.entites.Order;

@Service
public interface OrderService {
	
	public Order addOrder(Order order);
	List<Order> getAllOrder(); 
	Order findOrder(long id);
	void  deleteOrder(long id);
	public Order updateOrder(Long id, Order order);
	

}
