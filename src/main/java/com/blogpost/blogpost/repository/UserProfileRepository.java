package com.blogpost.blogpost.repository;

import com.blogpost.blogpost.model.UserAccount;
import com.blogpost.blogpost.model.UserProfile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
        UserProfile findByUsername(String username);
}
