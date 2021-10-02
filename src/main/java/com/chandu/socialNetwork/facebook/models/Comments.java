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
}
