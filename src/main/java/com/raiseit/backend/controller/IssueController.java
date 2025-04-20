package com.raiseit.backend.controller;

import com.raiseit.backend.dto.issue.IssueRequest;
import com.raiseit.backend.model.Issue;
import com.raiseit.backend.services.issues.IssueService;
import com.raiseit.backend.utils.ResultWrapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/create-issue")
    public ResponseEntity<ResultWrapper<?>> createIssue(@Valid @RequestBody IssueRequest request) {
        Issue issue = issueService.createIssue(request);
        return ResponseEntity.ok(ResultWrapper.success("Issue created successfully", issue));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultWrapper<?>> getIssue(@PathVariable Long id) {
        Issue issue = issueService.getIssueById(id);
        return ResponseEntity.ok(ResultWrapper.success("Issue retrieved", issue));
    }

    @PutMapping("update-issue/{id}")
    public ResponseEntity<ResultWrapper<?>> updateIssue(@PathVariable Long id, @Valid @RequestBody IssueRequest request) {
        Issue issue = issueService.updateIssue(id, request);
        return ResponseEntity.ok(ResultWrapper.success("Issue updated successfully", issue));
    }
}

