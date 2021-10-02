package com.chandu.socialNetwork.facebook.controllers;

import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.services.serviceImpl.PostsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {
    @Autowired
    PostsServiceImpl postsServiceImpl;

    @GetMapping("/posts")
    public ResponseEntity getAllpost() {
        Iterable<Posts> posts = postsServiceImpl.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PostMapping("/posts")
    public ResponseEntity AddPost(@RequestBody Posts posts) {
        Posts post = postsServiceImpl.AddPost(posts);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity listCommentsByPost(@PathVariable Integer postId) {
        Posts post = postsServiceImpl.getPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
