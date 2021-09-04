package com.chandu.socialNetwork.facebook.controllers;

import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostsService postsService;


    @GetMapping("/healthCheck")
    public String HealthCheck(){
        return "Hello Saichandu";
    }

    @PostMapping("/posts")
    public ResponseEntity AddPost(@RequestBody Posts posts){
        Posts post=postsService.AddPost(posts);
        System.out.println(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity getAllpost(){

        List<Posts> posts=postsService.getAllPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
}
