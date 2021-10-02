package com.chandu.socialNetwork.facebook.services.serviceImpl;

import com.chandu.socialNetwork.facebook.models.Posts;
import com.chandu.socialNetwork.facebook.repository.PostRepository;
import com.chandu.socialNetwork.facebook.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Posts AddPost(Posts posts){
        return postRepository.save(posts);
    }

    @Override
    public Iterable<Posts> getAllPosts(){
        return postRepository.findAll();
    }

    @Override
    public Posts getPostById(Integer id) {
        return postRepository.findById(id).orElseThrow(()->new RuntimeException("Post not found with the id"));
    }


}
