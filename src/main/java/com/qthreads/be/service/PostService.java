package com.qthreads.be.service;

import com.qthreads.be.db.dto.PostDto;

import java.util.List;

public interface PostService {
    public PostDto savePost(PostDto dto);

    public List<PostDto> getPostsByUserId(Long userId);
}
