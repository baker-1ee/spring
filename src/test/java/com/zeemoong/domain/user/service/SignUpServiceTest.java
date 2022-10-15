package com.zeemoong.domain.user.service;

import com.zeemoong.domain.user.service.after.SignUpService;
import com.zeemoong.domain.user.service.before.BeforeSignUpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SignUpServiceTest {

    @Autowired
    private BeforeSignUpService beforeSignUpService;

    @Autowired
    private SignUpService signUpService;

    @Test
    void beforeSignUpTest() {
        beforeSignUpService.signUp("sky@naver.com", "pass1234");
    }

    @Test
    void afterSignUpTest() {
        signUpService.signUp("sky@naver.com", "pass1234");
    }

}