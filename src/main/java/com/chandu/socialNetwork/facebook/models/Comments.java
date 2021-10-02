package com.chandu.socialNetwork.facebook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comments {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "posts_id", referencedColumnName = "postId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Posts posts;

    @Id
    @GeneratedValue
    private Integer commentId;

    private String name;

    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comments")
    private List<Likes> likesList;

//    public Posts getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Posts posts) {
//        this.posts = posts;
//    }
//
//    public Comments(Posts posts, List<Likes> likesList, String name, String comment, Integer commentId) {
//        this.commentId = commentId;
//        this.name = name;
//        this.comment = comment;
//        this.likesList = likesList;
//        this.posts = posts;
//
//    }
//
//    public List<Likes> getLikesList() {
//        return likesList;
//    }
//
//    public void setLikesList(List<Likes> likesList) {
//        this.likesList = likesList;
//    }
//
//    public Comments() {
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public Integer getCommentId() {
//        return commentId;
//    }
//
//    public void setCommentId(Integer commentId) {
//        this.commentId = commentId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
