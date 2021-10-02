package com.chandu.socialNetwork.facebook.controllers;

import com.chandu.socialNetwork.facebook.models.Comments;
import com.chandu.socialNetwork.facebook.repository.CommentRepository;
import com.chandu.socialNetwork.facebook.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity getCommentsByPost(@PathVariable Integer postId) {
        List<Comments> commentsList = commentsService.getCommentsByPostId(postId);
        return new ResponseEntity<>(commentsList, HttpStatus.OK);
    }
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity getCommentsByPostIdAndCommentId(@PathVariable Integer postId,@PathVariable Integer commentId) {
        Comments comments = commentsService.getCommentsByPostIdAndCommentId(commentId,postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity AddComment(@RequestBody Comments comment, @PathVariable Integer postId) {
        Comments comments = commentsService.addComment(comment, postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}