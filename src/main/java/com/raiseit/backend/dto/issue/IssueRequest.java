package com.raiseit.backend.dto.issue;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class IssueRequest {

    @NotNull
    private Integer statusId;

    private List<Long> mediaIds;

    private String description;

    private Float longitude;

    private Float latitude;

    private String address;

    @NotNull
    private Long issuerId;

    private List<Long> upVoterIds;
}

