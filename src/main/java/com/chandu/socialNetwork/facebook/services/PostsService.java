package com.chandu.socialNetwork.facebook.services;

import com.chandu.socialNetwork.facebook.models.Posts;

import java.util.List;

public interface PostsService {

    Posts AddPost(Posts posts);
    List<Posts> getAllPosts();
    Posts getPostById(Integer id);

}
