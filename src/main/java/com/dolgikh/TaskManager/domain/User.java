package com.dolgikh.TaskManager.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("users")
public record User(
        @Id UUID id,

        @NotBlank(message = "Имя пользователя не может быть пустым")
        @Size(min = 2, max = 50, message = "Имя пользователя должно быть от 2 до 50 символов")
        String name
) {}

