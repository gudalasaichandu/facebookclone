package com.chandu.socialNetwork.facebook.repository;

import com.chandu.socialNetwork.facebook.models.Comments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comments,Integer> {
//
//    @Query("select * from comments where commentId = :post_id")
//    List<Comments> getCommentsByPostId(@Param("post_id") Integer post_id);
}
