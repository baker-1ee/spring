package com.zeemoong.domain.admin.controller;

import com.zeemoong.domain.admin.response.AdminResponse;
import com.zeemoong.domain.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<AdminResponse> getAdmin() {
        return ResponseEntity.ok(adminService.getAdmin());
    }

}
