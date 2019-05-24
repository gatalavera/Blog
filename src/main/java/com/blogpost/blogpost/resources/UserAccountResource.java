package com.blogpost.blogpost.resources;

import com.blogpost.blogpost.model.UserAccount;
import com.blogpost.blogpost.model.UserProfile;
import com.blogpost.blogpost.model.dto.UpdateUserAccountDTO;
import com.blogpost.blogpost.model.dto.UserRegistrationDTO;
import com.blogpost.blogpost.repository.UserAccountRepository;
import com.blogpost.blogpost.repository.UserProfileRepository;
import com.blogpost.blogpost.util.BlogPostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("user-account/api")
public class UserAccountResource {
    @Autowired
    private BlogPostUtil blogPostUtil;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    private UserProfile userProfile;
    private  UserAccount userAccount;

    @GetMapping(value = "/get-user-account")
    public List<UserAccount> getAllUserAccounts() {
        List<UserAccount> userAccountList = userAccountRepository.findAll();
        Iterator<UserAccount> userAccountIterator = userAccountList.listIterator();
        UserAccount userAccount;

        while (userAccountIterator.hasNext()) {
            userAccount = userAccountIterator.next();
            userAccount.setUserProfile(userProfileRepository.findByUsername(userAccount.getUsername()));
        }
        return userAccountList;
    }

    @GetMapping(value = "/get-user-account/{id}")
    public UserAccount getUserAccountById(@PathVariable("id") String id) {
        UserAccount userAccount = userAccountRepository.findById(id).get();
        userAccount.setUserProfile(userProfileRepository.findByUsername(userAccount.getUsername()));
        return userAccount;
    }

    @DeleteMapping("/delete-user-account/{id}")
    public void deleteUserAccount(@PathVariable("id") String id) {
        UserAccount userAccount = userAccountRepository.findById(id).get();
        userAccountRepository.delete(userAccount);
    }

    @PostMapping("/create-user-account")
    public UserRegistrationDTO createUserAccount(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {

        userAccount.setAccountType(userRegistrationDTO.getAccountType());
        userAccount.setDateCreated(userRegistrationDTO.getDateCreated());
        userAccount.setUsername(userRegistrationDTO.getUsername());
        userAccount.setPassword(userRegistrationDTO.getPassword());
        userAccount.setEmail(userRegistrationDTO.getEmail());
        userAccount.setActive(true);
        userAccount.setLock(false);
        userAccount.setAccountType(userRegistrationDTO.getAccountType());

        userProfile.setUsername(userRegistrationDTO.getUsername());
        userProfile.setEmail(userRegistrationDTO.getEmail());
        userProfile.setFirstName(userRegistrationDTO.getFirstName());
        userProfile.setLastName(userRegistrationDTO.getLastName());
        userProfile.setMiddleName(userRegistrationDTO.getMiddleName());
        userProfile.setDateOfBirth(userRegistrationDTO.getDateOfBirth());
        userProfile.setAddress(userRegistrationDTO.getAddress());
        userProfile.setContactNumber(userRegistrationDTO.getContactNumber());

        userAccountRepository.save(userAccount);
        userProfileRepository.save(userProfile);
        return userRegistrationDTO;
    }

    @PutMapping("/update-user-account/")
    public void updateUserAccount(@Valid @RequestBody UpdateUserAccountDTO updateUserAccountDTO) {
        blogPostUtil.updateUserAccount(updateUserAccountDTO);
    }
}
