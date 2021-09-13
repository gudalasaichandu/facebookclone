package com.chandu.socialNetwork.facebook.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Posts {

    @Id
    @GeneratedValue
    private Integer id;

    private String message;

//    @Valid
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "posts")
    private List<Comments>  commentsList;

    public Posts() {
    }

    public Posts(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Posts(Integer id, String message, List<Comments> commentsList) {
        this.id = id;
        this.message = message;
        this.commentsList = commentsList;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
