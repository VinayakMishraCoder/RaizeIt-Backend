package com.raiseit.backend.repository;

import com.raiseit.backend.model.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueStatusRepository extends JpaRepository<IssueStatus, Integer> {}
