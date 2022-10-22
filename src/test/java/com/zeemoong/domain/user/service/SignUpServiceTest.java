package com.zeemoong.domain.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SignUpServiceTest {

    @Autowired
    private SignUpService signUpService;

    @Test
    void signUpTest() {
        signUpService.signUp("sky@naver.com", "pass1234");
    }

}