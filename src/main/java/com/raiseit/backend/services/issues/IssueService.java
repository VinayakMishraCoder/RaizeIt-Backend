package com.raiseit.backend.services.issues;


import com.raiseit.backend.dto.issue.IssueRequest;
import com.raiseit.backend.model.Issue;

public interface IssueService {

    Issue createIssue(IssueRequest request);

    Issue getIssueById(Long id);

    Issue updateIssue(Long id, IssueRequest request);
}
