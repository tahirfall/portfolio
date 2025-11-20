package com.portfolio_backend.service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String stack;
    private String link;
}
