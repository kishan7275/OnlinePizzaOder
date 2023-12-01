package com.opoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opoa.entites.User;
import com.opoa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public boolean authenticateUser(String userName, String password) {
	    User user = userRepository.findByUserName(userName);

	    if (user == null || !user.getPassword().equals(password)) {
	        return false;
	    } else {
	        return true;
	    }
	}



	
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(int id, User updatedUser) {
		User existingUser = getUserById(id);

		if (existingUser != null) {
			existingUser.setUserName(updatedUser.getUserName());
			existingUser.setPassword(updatedUser.getPassword());
			existingUser.setFirstName(updatedUser.getFirstName());
			existingUser.setLastName(updatedUser.getLastName());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setAddress(updatedUser.getAddress());
			existingUser.setPhone(updatedUser.getPhone());

			return userRepository.save(existingUser);
		}

		return null; // or throw an exception if the user with the given ID is not found
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
