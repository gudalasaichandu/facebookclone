package com.chandu.socialNetwork.facebook.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue
    private Integer postId;

    private Integer userId;

    private String title;

    private String body;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "posts")
    private List<Comments>  commentsList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "posts")
    private List<Likes>  likesList;









//    public Posts() {
//    }
//
//    public Posts(Integer postId, Integer userId, String title, String body, List<Comments> commentsList, List<Likes> likesList) {
//        this.postId = postId;
//        this.userId = userId;
//        this.title = title;
//        this.body = body;
//        this.commentsList = commentsList;
//        this.likesList = likesList;
//    }
//
//    public Integer getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Integer postId) {
//        this.postId = postId;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public List<Comments> getCommentsList() {
//        return commentsList;
//    }
//
//    public void setCommentsList(List<Comments> commentsList) {
//        this.commentsList = commentsList;
//    }
//
//    public List<Likes> getLikesList() {
//        return likesList;
//    }
//
//    public void setLikesList(List<Likes> likesList) {
//        this.likesList = likesList;
//    }
}
