package com.zeemoong.domain.user.event;

import com.zeemoong.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpEvent {
    User user;

    public static SignUpEvent from(User user) {
        return SignUpEvent.builder()
                .user(user)
                .build();
    }
}
