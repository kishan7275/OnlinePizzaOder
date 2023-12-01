package com.opoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opoa.entites.User;
import com.opoa.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login/{userName}/{password}")
	public ResponseEntity<Map<String, String>> authenticateUser(@PathVariable String userName, @PathVariable String password) {
	    Map<String, String> response = new HashMap<>();
	    
	    if (userService.authenticateUser(userName, password)) {
	        response.put("message", "Authentication successful");
	        return ResponseEntity.ok(response);
	    } else {
	        response.put("message", "Authentication failed");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}


	@GetMapping("/getAllUser")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user = userService.getUserById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	@PostMapping("/signup")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
		User updatedUser = userService.updateUser(id, user);
		return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
