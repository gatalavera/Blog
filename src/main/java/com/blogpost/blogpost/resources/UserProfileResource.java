package com.blogpost.blogpost.resources;

import com.blogpost.blogpost.model.UserAccount;
import com.blogpost.blogpost.model.UserProfile;
import com.blogpost.blogpost.model.dto.UpdateUserAccountDTO;
import com.blogpost.blogpost.repository.PostRepository;
import com.blogpost.blogpost.repository.UserAccountRepository;
import com.blogpost.blogpost.repository.UserProfileRepository;

import com.blogpost.blogpost.util.BlogPostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user-profiles/api")
public class UserProfileResource {
    @Autowired
    private BlogPostUtil blogPostUtil;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private PostRepository postRepository;

    private UserProfile userProfile;

    @GetMapping(value = "/get-user-profiles")
    public List<UserProfile> getAllUserProfiles() {
        List<UserProfile> userProfileList = userProfileRepository.findAll();
        Iterator<UserProfile> userProfileIterator = userProfileList.listIterator();

        while (userProfileIterator.hasNext()) {
            userProfile = userProfileIterator.next();
            userProfile.setPosts(postRepository.findByUsername(userProfile.getUsername()));
        }
        return userProfileList;
    }

    @GetMapping("get-user-profile/{id}")
    public UserProfile getUserProfileById(@PathVariable("id") String id){
        userProfile = userProfileRepository.findById(id).get();
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

    @PutMapping("/update-user-profile/")
    public void updateUserProfile(@Valid @RequestBody UpdateUserAccountDTO updateUserAccountDTO) {
        blogPostUtil.updateUserProfile(updateUserAccountDTO);
    }
}
