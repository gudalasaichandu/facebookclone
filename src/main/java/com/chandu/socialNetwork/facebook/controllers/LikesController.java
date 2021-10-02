package com.chandu.socialNetwork.facebook.controllers;

import com.chandu.socialNetwork.facebook.models.Likes;
import com.chandu.socialNetwork.facebook.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LikesController {

    @Autowired
    LikesService likesService;

    @GetMapping("/posts/{postId}/likes")
    public ResponseEntity getLikes(@PathVariable Integer postId) {
        Iterable<Likes> likesList= likesService.getLikes(postId);
        return new ResponseEntity<>(likesList, HttpStatus.OK);
    }
    @PostMapping("/posts/{postId}/likes")
    public ResponseEntity AddLikeToPost(@PathVariable Integer postId, @RequestBody Likes likes) {
        Likes like = likesService.AddLikeToPost(postId,likes);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }
    @PostMapping("/posts/{postId}/comments/{commentId}/likes")
    public ResponseEntity<Likes> addLikeToComment(@PathVariable Integer commentId,@PathVariable Integer postId, @RequestBody Likes likes) {
        Likes like = likesService.AddLikeToComment(postId,commentId,likes);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }
}
