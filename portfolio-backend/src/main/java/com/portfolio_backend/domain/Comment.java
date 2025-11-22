package com.portfolio_backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_full_name")
    private String userFullName;
    @Column(name = "position")
    private String position;
    @Column(name = "comment_text", columnDefinition = "TEXT")
    private String commentText;
    @Column(name = "snapshot_url")
    private String snapshotUrl;

}

