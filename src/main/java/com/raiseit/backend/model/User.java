package com.raiseit.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Column(name = "mobile_no")
    private String mobileNo;

    private String email;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

}

/**
 * Approval start by {last rank, is_approver=true, status=active}.
 * Next goes by {next lesser rank, is_approver=true, status-active=true}.
 * Last
 * */