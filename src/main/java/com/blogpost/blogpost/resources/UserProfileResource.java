package com.blogpost.blogpost.resources;

import com.blogpost.blogpost.model.UserProfile;
import com.blogpost.blogpost.repository.PostRepository;
import com.blogpost.blogpost.repository.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user-profiles/api")
public class UserProfileResource {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/get-user-profiles")
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @GetMapping("get-user-profile/{id}")
    public UserProfile getUserProfileById(@PathVariable("id") String id){
        UserProfile userProfile = userProfileRepository.findById(id).get();
        userProfile.setPosts(postRepository.findByUsername(userProfile.getUsername()));
       return userProfile;
    }

    @DeleteMapping("/delete-user-profile/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        UserProfile userProfile = userProfileRepository.findById(id).get();
        userProfileRepository.delete(userProfile);
    }

    @PostMapping("/create-user-profile")
    public UserProfile createUserProfile(@Valid @RequestBody UserProfile userProfile) {
        userProfile.setId(userProfile.getId());
        userProfileRepository.save(userProfile);
        return userProfile;
    }

    @PutMapping("/update-user-profile/{id}")
    public void updateUserProfile(@PathVariable("id") String id, @Valid @RequestBody UserProfile userProfile) {
        userProfile.setId(id);
        userProfileRepository.save(userProfile);
    }
}
