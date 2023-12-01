package com.opoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opoa.entites.NewPizza;
import com.opoa.service.NewPizzaService;
@CrossOrigin
@RestController
@RequestMapping("/newPizzas")
public class NewPizzaController {

    @Autowired
    private NewPizzaService newPizzaService;

    @GetMapping("/getAllPizza")
    public List<NewPizza> getAllNewPizzas() {
        return newPizzaService.getAllNewPizzas();
    }

    @GetMapping("/{id}")
    public NewPizza getNewPizzaById(@PathVariable String id) {
        return newPizzaService.getNewPizzaById(id);
    }

    @PostMapping("/addPizza")
    public NewPizza createNewPizza(@RequestBody NewPizza newPizza) {
        return newPizzaService.createNewPizza(newPizza);
    }

    @PutMapping("/{id}")
    public NewPizza updateNewPizza(@PathVariable String id, @RequestBody NewPizza newPizza) {
        return newPizzaService.updateNew(id, newPizza);
    }

    @DeleteMapping("/{id}")
    public void deleteNewPizza(@PathVariable String id) {
        newPizzaService.deleteNewPizza(id);
    }
}
