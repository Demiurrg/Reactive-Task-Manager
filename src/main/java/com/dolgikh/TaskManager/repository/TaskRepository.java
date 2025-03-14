package com.dolgikh.TaskManager.repository;

import com.dolgikh.TaskManager.domain.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TaskRepository extends ReactiveCrudRepository<Task, UUID> {
}
