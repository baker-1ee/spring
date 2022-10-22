package com.zeemoong.domain.user.service;

import com.zeemoong.domain.user.entity.User;
import com.zeemoong.domain.user.event.SignUpEventPublisher;
import com.zeemoong.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignUpService {

    private final UserRepository userRepository;
    private final SignUpEventPublisher signUpEventPublisher;

    @Transactional
    public void signUp(String email, String password) {
        User user = User.newInstance(email, password);
        userRepository.save(user);
        signUpEventPublisher.publish(user);
        System.out.println("user = " + user);
//        throw new RuntimeException("roll back");
    }
}
