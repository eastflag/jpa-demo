package com.jpabuddy.spring.demo.jpademo.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProjectDto implements Serializable {
    private final Long id;
    private final String name;
    private final UserDto manager;
    private final List<TaskDto> tasks;
}
