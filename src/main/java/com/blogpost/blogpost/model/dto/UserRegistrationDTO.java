package com.blogpost.blogpost.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegistrationDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String contactNumber;

    private String dateCreated;
    private String username;
    private String password;
    private String email;
    private String accountType;
}