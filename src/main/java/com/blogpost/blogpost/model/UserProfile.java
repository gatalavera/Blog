package com.blogpost.blogpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "UserProfile")
public class UserProfile {
    @Id
    private String id;
    private String username;
    private String  email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String contactNumber;
    private List<UserProfile> following;
    private List<UserProfile> followers;
    private String image;
    private List<Post> posts;
}
