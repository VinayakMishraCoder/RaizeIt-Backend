package com.raiseit.backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "media_file")
@Data
public class MediaFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    private String mediaUrl;

    private String mediaStatus;

    private String mediaType;

    private LocalDateTime modifiedLast;

    private LocalDateTime createdAt = LocalDateTime.now();
}
