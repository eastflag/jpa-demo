package com.jpabuddy.spring.demo.jpademo.mappers;

import com.jpabuddy.spring.demo.jpademo.dtos.ProjectDto;
import com.jpabuddy.spring.demo.jpademo.entities.Project;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectMapper {
    Project projectDtoToProject(ProjectDto projectDto);

    ProjectDto projectToProjectDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project updateProjectFromProjectDto(ProjectDto projectDto, @MappingTarget Project project);
}
