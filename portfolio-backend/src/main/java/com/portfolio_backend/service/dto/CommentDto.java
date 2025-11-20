package com.portfolio_backend.service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private String userFullName;
    private String position;
    private String commentText;
}

