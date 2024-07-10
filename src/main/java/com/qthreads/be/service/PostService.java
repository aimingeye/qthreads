package com.qthreads.be.service;

import com.qthreads.be.db.dto.PostDto;
import com.qthreads.be.dto.QthreadsAppResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    public ResponseEntity<QthreadsAppResponseDto> savePost(PostDto dto);

    public ResponseEntity<QthreadsAppResponseDto> getPostsByUserId(Long userId);
}
