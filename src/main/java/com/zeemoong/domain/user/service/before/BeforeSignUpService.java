package com.zeemoong.domain.user.service.before;

import com.zeemoong.domain.user.entity.User;
import com.zeemoong.domain.user.repository.UserRepository;
import com.zeemoong.domain.user.service.AggregateUserService;
import com.zeemoong.domain.user.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeforeSignUpService {

    private final UserRepository userRepository;
    private final SendEmailService sendEmailService;
    private final AggregateUserService aggregateUserService;

    public void signUp(String email, String password) {
        User user = User.newInstance(email, password);
        userRepository.save(user);
        sendEmailService.sendEmail(user);
        aggregateUserService.reAggregate(user);
    }
}
