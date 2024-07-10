package com.qthreads.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qthreads.be.db.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}
