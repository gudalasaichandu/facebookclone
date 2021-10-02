package com.chandu.socialNetwork.facebook.repository;

import com.chandu.socialNetwork.facebook.models.Comments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comments,Integer> {
    @Query(value = "select * from comments where posts_id = ?2 and comment_id=?1",nativeQuery = true)
    Comments getCommentByPostIdAndCommentId(Integer comment_id,Integer posts_id);
}
