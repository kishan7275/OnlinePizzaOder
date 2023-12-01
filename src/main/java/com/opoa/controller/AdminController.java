package com.opoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opoa.entites.Admin;
import com.opoa.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateAdmin(@RequestBody Admin authRequest) {
        String mailId = authRequest.getMailId();
        String password = authRequest.getPassword();

        if (adminService.authenticateAdmin(mailId, password)) {
            return ResponseEntity.ok().body("{\"message\": \"Authentication successful\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Authentication failed\"}");
        }
    }
}
