package com.raiseit.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "issue_status")
@Data
public class IssueStatus {

    @Id
    private Integer statusId;

    @Column(nullable = false)
    private String statusName;
}
