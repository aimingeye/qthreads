package com.qthreads.be.service;

import com.qthreads.be.db.dto.PostDto;
import com.qthreads.be.db.entity.PostEntity;
import com.qthreads.be.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto savePost(PostDto dto) {
        try{
            PostEntity post = new PostEntity();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setUser(post.getUser());
            post.setCreatedAt(LocalDateTime.now());
            postRepository.save(post);
            return dto;

        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<PostDto> getPostsByUserId(Long userId) {
        try{
            List<PostEntity> postEntities = postRepository.findByUserId(userId);
            return null;
        }catch(Exception e){
            return null;
        }
    }


}
