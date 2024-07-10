package com.qthreads.be.repository;

import com.qthreads.be.db.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUserId(Long userId);
}
