package com.chandu.socialNetwork.facebook.controllers;

import com.chandu.socialNetwork.facebook.exceptions.BadRequestException;
import com.chandu.socialNetwork.facebook.models.Comments;
import com.chandu.socialNetwork.facebook.models.Likes;
import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.repository.CommentRepository;
import com.chandu.socialNetwork.facebook.repository.LikeRepository;
import com.chandu.socialNetwork.facebook.repository.PostRepository;
import com.chandu.socialNetwork.facebook.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PostController {
    @Autowired
    PostsService postsService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    LikeRepository likeRepository;



    @GetMapping("/healthCheck")
    public String HealthCheck() {
        return "Facebook Service is up and running.";
    }

    @PostMapping("/posts")
    public ResponseEntity AddPost(@RequestBody Posts posts) {
        Posts post = postsService.AddPost(posts);
        System.out.println(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity getAllpost() {

        List<Posts> posts = postsService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity AddComment(@RequestBody Comments comment, @PathVariable Integer postId) {

        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Sai"));
        comment.setPosts(post);
        commentRepository.save(comment);

        return new ResponseEntity<>(comment, HttpStatus.OK);

    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity AddComment(@PathVariable Integer postId) {

        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Sai"));
//        List<Comments> commentsList= commentRepository.getCommentsByPostId(postId);
        List<Comments> posts = (List<Comments>) commentRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);

    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity listCommentsByPost(@PathVariable Integer postId) {
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Sai"));

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/likes")
    public ResponseEntity AddLike(@PathVariable Integer postId, @RequestBody Likes likes) {

        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Sai"));
        likes.setPosts(post);
        likeRepository.save(likes);

        return new ResponseEntity<>(likes, HttpStatus.OK);
    }
    @GetMapping("/posts/{postId}/likes")
    public ResponseEntity getLikes(@PathVariable Integer postId) {

        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Sai"));
//        List<Comments> commentsList= commentRepository.getCommentsByPostId(postId);
        List<Likes> likesList = (List<Likes>) likeRepository.findAll();
        return new ResponseEntity<>(likesList, HttpStatus.OK);

    }

    @PostMapping("/posts/{postId}/comments/1/likes")
    public ResponseEntity AddLiketoComment(@PathVariable Integer commentId, @RequestBody Likes likes) {

        Comments comments = commentRepository.findById(1)
                .orElseThrow(() -> new BadRequestException("Sai"));
        likes.setComments(comments);
        likeRepository.save(likes);

        return new ResponseEntity<>(likes, HttpStatus.OK);
    }



}
