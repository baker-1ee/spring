package com.zeemoong.domain.user.service;

import com.zeemoong.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AggregateUserService {
    public void reAggregate(User user) {
        System.out.println(user.getEmail() + " 회원 추가하여 유저 현황 재집계 완료하였습니다.");
    }
}
