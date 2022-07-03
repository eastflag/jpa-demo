package com.jpabuddy.spring.demo.jpademo.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TaskDto implements Serializable {
    private final Long id;
    private final String name;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}
