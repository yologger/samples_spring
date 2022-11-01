package com.yologger.samples.jackson_objectmapper.controller;

import com.yologger.samples.jackson_objectmapper.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @GetMapping("/post")
    public ResponseEntity<Post> getPost() {
        Post post = Post.builder()
                .title("title")
                .content("content")
                .build();
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @DeleteMapping("/post")
    public ResponseEntity<String> deletePost(@RequestBody Post post) {
        return new ResponseEntity<>(post.getId(), HttpStatus.NO_CONTENT);
    }
}
