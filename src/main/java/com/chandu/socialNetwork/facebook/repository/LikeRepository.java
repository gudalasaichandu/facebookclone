package com.chandu.socialNetwork.facebook.repository;


import com.chandu.socialNetwork.facebook.models.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Likes,Integer> {

}
