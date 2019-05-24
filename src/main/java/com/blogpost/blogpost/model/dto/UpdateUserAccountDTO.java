package com.blogpost.blogpost.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUserAccountDTO {
    private  String id;
    private String username;
    private String password;
    private String email;
}
