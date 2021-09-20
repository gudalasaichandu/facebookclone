package com.chandu.socialNetwork.facebook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Likes {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "posts_id", referencedColumnName = "postId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Posts posts;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "comments_id", referencedColumnName = "commentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Comments comments;


    @Id
    @GeneratedValue
    private Integer likeId;

    private Integer userId;

    private Integer resourceId;

    private String name;

    private String type;

    public Likes() {
    }

    public Likes(Posts posts, Integer likeId, Integer userId, String name, String type, Integer resourceId, Comments comments) {
        this.posts = posts;
        this.comments = comments;
        this.likeId = likeId;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.resourceId=resourceId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
