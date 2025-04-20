package com.raiseit.backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "issue")
@Data
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private IssueStatus status;

    @ManyToMany
    @JoinTable(
            name = "issue_media",
            joinColumns = @JoinColumn(name = "issue_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private List<MediaFile> mediaList;

    private String description;

    private Float longitude;

    private Float latitude;

    private String address;

    @Column(name = "issuer_id")
    private Long issuerId;

    @ManyToMany
    @JoinTable(
            name = "issue_upvoters",
            joinColumns = @JoinColumn(name = "issue_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> upVoters;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
}
