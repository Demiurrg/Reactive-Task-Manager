package com.dolgikh.TaskManager.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("projects")
public class Project {
    @Id
    private UUID id;
    private String name;
}
