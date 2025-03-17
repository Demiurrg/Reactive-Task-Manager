package com.dolgikh.TaskManager.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("projects")
public record Project(
        @Id UUID id,

        @NotBlank(message = "Название проекта не может быть пустым")
        @Size(min = 3, max = 100, message = "Название проекта должно быть от 3 до 100 символов")
        String name
) {}

