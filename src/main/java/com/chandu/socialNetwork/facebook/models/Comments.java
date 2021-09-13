package com.chandu.socialNetwork.facebook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Comments {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Posts posts;

    private String comment;

    @Id
    @GeneratedValue
    private Integer commentId;

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public Comments(String comment, Integer commentId) {
        this.comment = comment;
        this.commentId = commentId;
    }

    public Comments() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
