package com.opoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.opoa.entites.Payment;

@Service
public interface PaymentService {
	Payment savePayment(Payment payment);

	List<Payment> getAllPayments();

	Payment getPaymentById(Integer paymentId);

	// Additional methods as needed
}
