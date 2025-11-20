package com.portfolio_backend.mapper;

import com.portfolio_backend.domain.Project;
import com.portfolio_backend.service.dto.ProjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto toDto(Project entity);
    Project toEntity(ProjectDto dto);
}
