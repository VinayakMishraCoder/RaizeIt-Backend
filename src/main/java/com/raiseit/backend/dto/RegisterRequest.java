package com.raiseit.backend.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String password;
    private String mobileNo;
    private String email;
    private String status;
    private String role;
}
