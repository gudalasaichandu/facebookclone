package com.chandu.socialNetwork.facebook.services;

import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    PostRepository postRepository;

    public Posts AddPost(Posts posts){
        return postRepository.save(posts);
    }

    public List<Posts> getAllPosts(){
        return (List<Posts>) postRepository.findAll();
    }

}
