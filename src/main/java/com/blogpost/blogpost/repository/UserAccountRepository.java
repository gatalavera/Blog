package com.blogpost.blogpost.repository;

import com.blogpost.blogpost.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {
    UserAccount findByUsername(String username);

}
