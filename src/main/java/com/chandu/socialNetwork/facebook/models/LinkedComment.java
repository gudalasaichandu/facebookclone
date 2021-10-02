package com.chandu.socialNetwork.facebook.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue("comment")
@Entity
@Table(name = "likes")
public class LinkedComment extends Likes{
}
