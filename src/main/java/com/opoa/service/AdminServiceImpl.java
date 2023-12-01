package com.opoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opoa.entites.Admin;
import com.opoa.entites.User;
import com.opoa.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public boolean authenticateAdmin(String mailId, String password) {
		Admin admin;
		try {
			admin= adminRepository.findById(mailId).get();
		}catch(Exception ex) {
			return false;
		}
		if(!(admin.getPassword().equals(password)))
			return false;
		else
			return true;

	}
}
