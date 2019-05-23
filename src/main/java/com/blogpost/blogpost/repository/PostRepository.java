package com.blogpost.blogpost.repository;

import com.blogpost.blogpost.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByUsername(String username);

}
