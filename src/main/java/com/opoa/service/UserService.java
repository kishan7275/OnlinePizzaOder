package com.opoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.opoa.entites.User;

@Service
public interface UserService {

	List<User> getAllUsers();
	User getUserById(int id);
	User createUser(User user);
	User updateUser(int id, User user);
	void deleteUser(int id);
	
	boolean authenticateUser(String userName, String password);
}
