package com.chandu.socialNetwork.facebook.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue("post")
@Entity
@Table(name = "likes")
public class LinkedPost extends Likes{
}
