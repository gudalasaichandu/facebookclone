package com.chandu.socialNetwork.facebook.services;

import com.chandu.socialNetwork.facebook.models.Likes;

public interface LikesService {

    Iterable<Likes> getLikes(Integer postId);
    Likes AddLikeToPost(Integer postId, Likes likes);
    Likes AddLikeToComment(Integer postId,Integer commentId, Likes likes);
}
