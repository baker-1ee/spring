package com.zeemoong.domain.user.event;

import com.zeemoong.domain.user.service.AggregateUserService;
import com.zeemoong.domain.user.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class SignUpEventListener {

    private final SendEmailService sendEmailService;
    private final AggregateUserService aggregateUserService;

    @TransactionalEventListener
    @Order(1)
    public void sendEmail(SignUpEvent event) {
        sendEmailService.sendEmail(event.getUser());
    }

    @TransactionalEventListener
    @Order(2)
    public void reAggregate(SignUpEvent event) {
        aggregateUserService.reAggregate(event.getUser());
    }
}
