package com.opoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opoa.entites.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Additional query methods can be added if needed
}


