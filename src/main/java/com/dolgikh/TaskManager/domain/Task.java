package com.dolgikh.TaskManager.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("tasks")
public class Task {
    @Id
    private UUID id;
    private String title;
    private String description;
    private Status status;
    private UUID projectId;
}
