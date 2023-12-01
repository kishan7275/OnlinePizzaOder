package com.opoa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opoa.entites.Payment;
import com.opoa.service.PaymentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("addPayment")
	public Payment addPayment(@Valid @RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}

	@GetMapping("/getAllPayments")
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

	@GetMapping("/{paymentId}")
	public Payment getPaymentById(@PathVariable Integer paymentId) {
		return paymentService.getPaymentById(paymentId);
	}

}
