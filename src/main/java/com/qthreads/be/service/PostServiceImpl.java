package com.qthreads.be.service;

import com.qthreads.be.db.dto.PostDto;
import com.qthreads.be.db.entity.PostEntity;
import com.qthreads.be.dto.QthreadsAppResponseDto;
import com.qthreads.be.repository.PostRepository;
import com.qthreads.be.utility.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommonUtility commonUtility;

    @Override
    public ResponseEntity<QthreadsAppResponseDto> savePost(PostDto dto) {
        Map<Object, Object> data = new HashMap<>();
        try{
            PostEntity post = new PostEntity();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setUser(post.getUser());
            post.setCreatedAt(LocalDateTime.now());
            postRepository.save(post);
            return commonUtility.getResponseSuccessObject(data, "Successfully saved the post!");

        }catch(Exception e){
            return commonUtility.getResponseFailureObject(data, "Failed to save the post");
        }
    }

    @Override
    public ResponseEntity<QthreadsAppResponseDto> getPostsByUserId(Long userId) {
        Map<Object, Object> data = new HashMap<>();
        try{
            List<PostEntity> postEntities = postRepository.findByUserId(userId);
            data.put("posts", postEntities);
            return commonUtility.getResponseSuccessObject(data, "Fetched posts successfully");
        }catch(Exception e){
            return commonUtility.getResponseFailureObject(data, "Could not get the posts for the user");
        }
    }


}
