package com.zeemoong.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    public static User newInstance(String email, String password) {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
