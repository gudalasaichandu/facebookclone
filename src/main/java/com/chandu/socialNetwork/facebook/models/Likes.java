package com.chandu.socialNetwork.facebook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)
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

    @Column(name = "type", insertable = false, updatable = false)
    private String type;
}
