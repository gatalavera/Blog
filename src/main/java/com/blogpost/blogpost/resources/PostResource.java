package com.blogpost.blogpost.resources;

import com.blogpost.blogpost.model.Post;
import com.blogpost.blogpost.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post/api")
public class PostResource {
    @Autowired
    private PostRepository postRepository;

    Post post = new Post();

    @GetMapping("/get-posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/get-post/{id}")
    public Post getPostById(@PathVariable ("id") String id){
        return postRepository.findById(id).get();
    }

    @DeleteMapping("/delete-post/{id}")
    public void deletePost(@PathVariable("id") String id){
        post = postRepository.findById(id).get();
        postRepository.delete(post);
    }

    @PostMapping("/create-post")
    public Post createPost(@Valid @RequestBody Post post){
        post.setId(post.getId());
        postRepository.save(post);
        return  post;
    }

    @PutMapping("/update-post/{id}")
    public void updatePost(@PathVariable("id") String id, @Valid @RequestBody Post post){
        post.setId(id);
        postRepository.save(post);
    }
}
