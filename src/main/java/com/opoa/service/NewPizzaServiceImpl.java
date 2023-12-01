package com.opoa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opoa.entites.NewPizza;
import com.opoa.repository.NewPizzaRepository;

@Service
public class NewPizzaServiceImpl implements NewPizzaService {

	@Autowired
	private NewPizzaRepository newPizzaRepository;

	@Override
	public List<NewPizza> getAllNewPizzas() {
		return newPizzaRepository.findAll();
	}

	@Override
	public NewPizza getNewPizzaById(String id) {
		return newPizzaRepository.findById(id).orElse(null);
	}

	@Override
	public NewPizza createNewPizza(NewPizza NewPizza) {
		return newPizzaRepository.save(NewPizza);
	}

	@Override
	public NewPizza updateNew(String id, NewPizza newPizza) {
		NewPizza existingNewPizza = getNewPizzaById(id);

		if (existingNewPizza != null) {
			existingNewPizza.setName(newPizza.getName());
			existingNewPizza.setPrice(newPizza.getPrice());
			existingNewPizza.setQuantityAvailable(newPizza.getQuantityAvailable());

			return newPizzaRepository.save(existingNewPizza);
		}

		return null; // or throw an exception if the NewPizza with the given ID is not found
	}

	@Override
	public void deleteNewPizza(String id) {
		newPizzaRepository.deleteById(id);
	}

}
