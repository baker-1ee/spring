package com.zeemoong.domain.user.service.after;

import com.zeemoong.domain.user.entity.User;
import com.zeemoong.domain.user.event.SignUpEventPublisher;
import com.zeemoong.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;
    private final SignUpEventPublisher signUpEventPublisher;

    public void signUp(String email, String password) {
        User user = User.newInstance(email, password);
        userRepository.save(user);
        signUpEventPublisher.publish(user);
        System.out.println("signUp complete!");
    }
}
