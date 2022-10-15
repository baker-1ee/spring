package com.zeemoong.domain.user.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String email;
    private String password;

    public static User newInstance(String email, String password) {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
