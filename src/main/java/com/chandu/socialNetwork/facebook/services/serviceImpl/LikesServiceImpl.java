package com.chandu.socialNetwork.facebook.services.serviceImpl;

import com.chandu.socialNetwork.facebook.exceptions.BadRequestException;
import com.chandu.socialNetwork.facebook.models.Comments;
import com.chandu.socialNetwork.facebook.models.Likes;
import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.repository.CommentRepository;
import com.chandu.socialNetwork.facebook.repository.LikeRepository;
import com.chandu.socialNetwork.facebook.repository.PostRepository;
import com.chandu.socialNetwork.facebook.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    LikeRepository likeRepository;

    public Iterable<Likes> getLikes(Integer postId){
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Post not found"));
        Iterable<Likes> likesList = likeRepository.findAll();
        return likesList;
    }
    public Likes AddLikeToPost(Integer postId, Likes likes){
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Post not found"));
        likes.setPosts(post);
        likeRepository.save(likes);
        return likes;
    }
    public Likes AddLikeToComment(Integer postId,Integer commentId, Likes likes){
        Posts posts= postRepository.findById(1).orElseThrow(()-> new BadRequestException("Post not found"));
        Comments comments = commentRepository.getCommentByPostIdAndCommentId(commentId,postId);
        likes.setComments(comments);
        likeRepository.save(likes);
        return likes;
    }

}
