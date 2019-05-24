package com.blogpost.blogpost.util;

import com.blogpost.blogpost.model.UserAccount;
import com.blogpost.blogpost.model.UserProfile;
import com.blogpost.blogpost.model.dto.UpdateUserAccountDTO;
import com.blogpost.blogpost.repository.UserAccountRepository;
import com.blogpost.blogpost.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogPostUtil {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    private UserAccount userAccount;
    private UserProfile userProfile;

    public void updateUserAccount(UpdateUserAccountDTO updateUserAccountDTO) {

        userAccount.setUsername(updateUserAccountDTO.getUsername());
        userAccount.setPassword(updateUserAccountDTO.getPassword());
        userAccount.setEmail(updateUserAccountDTO.getEmail());

        userProfile.setUsername(updateUserAccountDTO.getUsername());
        userProfile.setEmail(updateUserAccountDTO.getEmail());

        userProfileRepository.save(userProfile);
        userAccountRepository.save(userAccount);
    }
}
