package com.chandu.socialNetwork.facebook.services;

import com.chandu.socialNetwork.facebook.models.Posts;

public interface PostsService {

    Posts AddPost(Posts posts);
    Iterable<Posts> getAllPosts();
    Posts getPostById(Integer id);

}
