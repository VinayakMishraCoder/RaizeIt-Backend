package com.raiseit.backend.repository;

import com.raiseit.backend.model.MediaFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {}
