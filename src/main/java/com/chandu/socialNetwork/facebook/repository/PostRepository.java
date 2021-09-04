package com.chandu.socialNetwork.facebook.repository;

import com.chandu.socialNetwork.facebook.models.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Posts,Integer> {
}
