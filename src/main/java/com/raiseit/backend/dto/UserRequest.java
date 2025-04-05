package com.raiseit.backend.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String mobileNo;
    private String status;
    private String role;
}

