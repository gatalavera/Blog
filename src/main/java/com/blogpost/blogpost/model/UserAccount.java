package com.blogpost.blogpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "UserAccount")
public class UserAccount {
    @Id
    public  String id;
    private String dateCreated;
    private String username;
    private String password;
    private String email;
    private boolean isLock;
    private boolean isActive;
    private String accountType;
    private UserProfile userProfile;
}
