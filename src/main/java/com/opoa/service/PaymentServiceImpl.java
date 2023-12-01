package com.opoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opoa.entites.Payment;
import com.opoa.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(Integer paymentId) {
		return paymentRepository.findById(paymentId).orElse(null);
	}

}
