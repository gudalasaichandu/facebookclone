package com.chandu.socialNetwork.facebook.repository;

import com.chandu.socialNetwork.facebook.models.Comments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comments,Integer> {
//
//    @Query("select * from comments where commentId = :post_id")
//    List<Comments> getCommentsByPostId(@Param("post_id") Integer post_id);

    @Query(value = "select * from comments where posts_id = ?2 and comment_id=?1",nativeQuery = true)
    Comments getCommentByPostIdAndCommentId(Integer comment_id,Integer posts_id);
}
