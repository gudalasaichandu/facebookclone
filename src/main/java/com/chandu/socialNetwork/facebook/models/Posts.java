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
}
