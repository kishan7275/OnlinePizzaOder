package com.opoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opoa.entites.NewPizza;

@Repository
public interface NewPizzaRepository extends JpaRepository<NewPizza, String> {
	// You can add custom query methods if needed
}
