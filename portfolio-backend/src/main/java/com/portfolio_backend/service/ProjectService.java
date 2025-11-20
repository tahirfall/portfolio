package com.portfolio_backend.service;


import com.portfolio_backend.service.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto dto);
    ProjectDto getProject(Long id);
    List<ProjectDto> getAllProjects();
    ProjectDto updateProject(Long id, ProjectDto dto);
    void deleteProject(Long id);
}

