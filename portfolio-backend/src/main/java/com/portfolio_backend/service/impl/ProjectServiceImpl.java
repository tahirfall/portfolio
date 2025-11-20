package com.portfolio_backend.service.impl;


import com.portfolio_backend.domain.Project;
import com.portfolio_backend.exception.ResourceNotFoundException;
import com.portfolio_backend.mapper.ProjectMapper;
import com.portfolio_backend.repository.ProjectRepository;
import com.portfolio_backend.service.ProjectService;
import com.portfolio_backend.service.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectDto createProject(ProjectDto dto) {
        Project project = projectMapper.toEntity(dto);
        return projectMapper.toDto(projectRepository.save(project));
    }

    @Override
    public ProjectDto getProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        return projectMapper.toDto(project);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto updateProject(Long id, ProjectDto dto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setStack(dto.getStack());
        project.setLink(dto.getLink());

        return projectMapper.toDto(projectRepository.save(project));
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        projectRepository.delete(project);
    }
}

