package com.chandu.socialNetwork.facebook.controllers;

import com.chandu.socialNetwork.facebook.exceptions.BadRequestException;
import com.chandu.socialNetwork.facebook.models.Comments;
import com.chandu.socialNetwork.facebook.models.Likes;
import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.repository.CommentRepository;
import com.chandu.socialNetwork.facebook.repository.LikeRepository;
import com.chandu.socialNetwork.facebook.repository.PostRepository;
import com.chandu.socialNetwork.facebook.services.serviceImpl.PostsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {
    @Autowired
    PostsServiceImpl postsServiceImpl;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    LikeRepository likeRepository;

    @GetMapping("/posts")
    public ResponseEntity getAllpost() {

        List<Posts> posts = postsServiceImpl.getAllPosts();
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
