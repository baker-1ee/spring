package com.zeemoong.domain.admin.service;

import com.zeemoong.domain.admin.response.AdminResponse;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public AdminResponse getAdmin() {
        return AdminResponse.builder()
                .name("이한슬")
                .email("sky@naver.com")
                .build();
    }
}
