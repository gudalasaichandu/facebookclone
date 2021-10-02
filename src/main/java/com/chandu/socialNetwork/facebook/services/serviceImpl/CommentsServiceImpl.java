package com.chandu.socialNetwork.facebook.services.serviceImpl;

import com.chandu.socialNetwork.facebook.exceptions.BadRequestException;
import com.chandu.socialNetwork.facebook.models.Comments;
import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.repository.CommentRepository;
import com.chandu.socialNetwork.facebook.repository.PostRepository;
import com.chandu.socialNetwork.facebook.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    public  List<Comments> getCommentsByPostId(Integer postId){
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Post not Found"));

        List<Comments> commentsList = post.getCommentsList();
        return commentsList;
    }
    public Comments  getCommentsByPostIdAndCommentId(Integer postId,Integer commentId){
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Post not Found"));
        Comments comments = commentRepository.getCommentByPostIdAndCommentId(commentId,postId);
        return comments;
    }
    public Comments addComment(Comments comment,Integer postId){
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Post not found"));
        comment.setPosts(post);
        commentRepository.save(comment);
        return comment;
    }
}
