package com.zeemoong.domain.user.repository;

import com.zeemoong.domain.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserMemoryRepository implements UserRepository {

    private static final Map<Long, User> store = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong();

    @Override
    public User save(User user) {
        if(user.getId() == null) {
            user.setId(sequence.incrementAndGet());
        }
        store.put(user.getId(), user);
        System.out.println(user.getId() + " 사번으로 회원 가입 되었습니다.");
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
