package com.raiseit.backend.services.issues;

import com.raiseit.backend.dto.issue.IssueRequest;
import com.raiseit.backend.model.*;
import com.raiseit.backend.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private IssueStatusRepository statusRepository;

    @Autowired
    private MediaFileRepository mediaFileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Issue createIssue(IssueRequest request) {
        Issue issue = mapToEntity(request);
        issue.setCreatedAt(LocalDateTime.now());
        issue.setUpdatedAt(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    @Override
    public Issue getIssueById(Long id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Issue not found with id: " + id));
    }

    @Override
    public Issue updateIssue(Long id, IssueRequest request) {
        Issue existing = issueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Issue not found with id: " + id));

        Issue updated = mapToEntity(request);
        updated.setId(existing.getId());
        updated.setCreatedAt(existing.getCreatedAt());
        updated.setUpdatedAt(LocalDateTime.now());

        return issueRepository.save(updated);
    }


    /**
     * Helper function.
     * */
    private Issue mapToEntity(IssueRequest request) {
        Issue issue = new Issue();

        IssueStatus status = statusRepository.findById(request.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));

        issue.setStatus(status);
        issue.setDescription(request.getDescription());
        issue.setLongitude(request.getLongitude());
        issue.setLatitude(request.getLatitude());
        issue.setAddress(request.getAddress());
        issue.setIssuerId(request.getIssuerId());

        if (request.getMediaIds() != null && !request.getMediaIds().isEmpty()) {
            List<MediaFile> mediaList = mediaFileRepository.findAllById(request.getMediaIds());
            issue.setMediaList(mediaList);
        }

        if (request.getUpVoterIds() != null && !request.getUpVoterIds().isEmpty()) {
            List<User> upVoters = userRepository.findAllById(request.getUpVoterIds());
            issue.setUpVoters(upVoters);
        }

        return issue;
    }
}
