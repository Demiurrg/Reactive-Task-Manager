package com.dolgikh.TaskManager.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("tasks")
public record Task(
        @Id UUID id,

        @NotBlank(message = "Название задачи не может быть пустым")
        @Size(min = 5, max = 100, message = "Название задачи должно быть от 5 до 100 символов")
        String title,

        @Size(max = 500, message = "Описание задачи не должно превышать 500 символов")
        String description,

        @NotNull(message = "Статус задачи не может быть пустым")
        Status status,

        @NotNull(message = "Задача должна принадлежать проекту")
        UUID projectId
) {}

