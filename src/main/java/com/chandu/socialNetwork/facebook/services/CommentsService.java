package com.chandu.socialNetwork.facebook.services;

import com.chandu.socialNetwork.facebook.models.Comments;

import java.util.List;

public interface CommentsService {

    List<Comments>  getCommentsByPostId(Integer postId);

    Comments addComment(Comments comments,Integer postId);

    Comments  getCommentsByPostIdAndCommentId(Integer postId,Integer commentId);

}
