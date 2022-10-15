package com.zeemoong.domain.user.event;

import com.zeemoong.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(User user) {
        SignUpEvent event = SignUpEvent.from(user);
        applicationEventPublisher.publishEvent(event);
    }
}
