package com.blogpost.blogpost.repository;

import com.blogpost.blogpost.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}