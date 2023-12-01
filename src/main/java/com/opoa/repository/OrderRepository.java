package com.opoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opoa.entites.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

	
}
