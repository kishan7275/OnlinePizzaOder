package com.opoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.opoa.entites.NewPizza;

@Service
public interface NewPizzaService {

	List<NewPizza> getAllNewPizzas();

	NewPizza getNewPizzaById(String id);

	NewPizza createNewPizza(NewPizza newPizza);

	NewPizza updateNew(String id, NewPizza newPizza);

	void deleteNewPizza(String id);
}
