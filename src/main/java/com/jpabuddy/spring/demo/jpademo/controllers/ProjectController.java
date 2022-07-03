package com.jpabuddy.spring.demo.jpademo.controllers;

import com.jpabuddy.spring.demo.jpademo.dtos.ProjectDto;
import com.jpabuddy.spring.demo.jpademo.entities.Project;
import com.jpabuddy.spring.demo.jpademo.mappers.ProjectMapper;
import com.jpabuddy.spring.demo.jpademo.repositories.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;

    @GetMapping("/project/find/{name}")
    public List<ProjectDto> findByName(@PathVariable String name) {
        List<Project> projectList = projectRepository.findByName(name);
        return projectList.stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/project/new")
    public ProjectDto saveProject(@RequestBody @NonNull @Valid ProjectDto projectDto) {
        Project projectEntity = projectMapper.projectDtoToProject(projectDto);
        return projectMapper.projectToProjectDto(projectRepository.save(projectEntity));
    }

    @PutMapping("/project/update")
    public ProjectDto updateProject(@RequestBody @NonNull @Valid ProjectDto projectDto) {
        if (projectDto.getId() == null) {
            throw new IllegalArgumentException("Project ID is missing. use /new to create a project");
        }

        Project projectEntity = projectRepository.findById(projectDto.getId()).orElseThrow(EntityNotFoundException::new);
        projectMapper.updateProjectFromProjectDto(projectDto, projectEntity);
        return projectMapper.projectToProjectDto(projectRepository.save(projectEntity));
    }
}
