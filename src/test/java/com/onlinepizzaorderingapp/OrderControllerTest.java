package com.onlinepizzaorderingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.opoa.OnlinePizzaOrderingAppApplication;
import com.opoa.controller.OrderController;
import com.opoa.entites.Order;
import com.opoa.exception.OrderNotFoundException;
import com.opoa.service.OrderService;

@SpringBootTest(classes = OnlinePizzaOrderingAppApplication.class)
class OrderControllerTest {

	@Mock
	private OrderService orderService;

	@InjectMocks
	private OrderController orderController;

	@Test
    void testGetAllOrders() {
        when(orderService.getAllOrder()).thenReturn(Collections.emptyList());

        assertEquals(Collections.emptyList(), orderController.getAllOrders());
        verify(orderService, times(1)).getAllOrder();
    }

	@Test
	void testGetOrderById() {
		Order order = new Order(1L, "123", LocalDate.now(), "Pending");

		when(orderService.findOrder(1L)).thenReturn(order);

		Order response = orderController.getOrderById(1L);
		assertEquals(order, response);

		when(orderService.findOrder(2L)).thenReturn(null);

		try {
			orderController.getOrderById(2L);
		} catch (OrderNotFoundException e) {
			assertEquals("Order with id 2 not found", e.getMessage());
		}
	}

	@Test
	void testCreateOrder() {
		Order order = new Order(1L, "123", LocalDate.now(), "Pending");

		when(orderService.addOrder(any(Order.class))).thenReturn(order);

		assertEquals(order, orderController.createOrder(order));
		verify(orderService, times(1)).addOrder(order);
	}

	@Test
	void testUpdateOrder() {
		Order order = new Order(1L, "123", LocalDate.now(), "Pending");

		when(orderService.updateOrder(1L, order)).thenReturn(order);

		assertEquals(order, orderController.updateOrder(1L, order));
		verify(orderService, times(1)).updateOrder(1L, order);
	}

}
