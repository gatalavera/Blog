package com.blogpost.blogpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "Post")
public class Post {
    @Id
    private String id;
    private String title;
    private String body;
    private String datePosted;
    private String dateUpdated;
    private List<Post> tags;
    private int likes;
    Set<UserProfile> userProfiles = new HashSet<>();
}
