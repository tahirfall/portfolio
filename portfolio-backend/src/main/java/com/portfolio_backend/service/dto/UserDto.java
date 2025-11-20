package com.portfolio_backend.service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String profile;
    private String professionalSummary;
    private String email;
    private String phone;
    private String resume;
}

