package com.qthreads.be.controller;

import com.qthreads.be.db.dto.PostDto;
import com.qthreads.be.db.entity.PostEntity;
import com.qthreads.be.dto.QthreadsAppResponseDto;
import com.qthreads.be.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/createpost")
    public ResponseEntity<QthreadsAppResponseDto> createPost(@RequestBody PostDto post) {
        return postService.savePost(post);
    }

//    @PostMapping("/user/getposts")
//    public ResponseEntity<List<PostDto>> getPostsByUser(@RequestBody ) {
//        return ResponseEntity.ok(postService.getPostsByUserId(userId));
//    }

    // Other endpoints
}
