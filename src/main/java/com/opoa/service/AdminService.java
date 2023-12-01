package com.opoa.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {

	boolean authenticateAdmin(String mailId, String password);

}
