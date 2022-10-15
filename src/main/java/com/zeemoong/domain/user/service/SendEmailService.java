package com.zeemoong.domain.user.service;

import com.zeemoong.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    public void sendEmail(User user) {
        System.out.println(user.getEmail() + " 에게 email 을 전송하였습니다.");
    }
}
