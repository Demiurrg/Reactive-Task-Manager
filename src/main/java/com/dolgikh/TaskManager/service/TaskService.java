package com.dolgikh.TaskManager.service;

import com.dolgikh.TaskManager.domain.Task;
import com.dolgikh.TaskManager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Mono<Task> getById(UUID id) {
        return taskRepository.findById(id);
    }

    public Flux<Task> getAll() {
        return taskRepository.findAll();
    }

    public Mono<Task> save(Task task) {
        return taskRepository.save(task);
    }

    public Mono<Task> update(UUID id, Task updatedTask) {
        return taskRepository.findById(id)
                .flatMap(_ -> {
                    Task newTask = new Task(
                            id,
                            updatedTask.title(),
                            updatedTask.description(),
                            updatedTask.status(),
                            updatedTask.projectId()
                    );
                    return taskRepository.save(newTask);
                });
    }

    public Mono<Void> delete(UUID id) {
        return taskRepository.deleteById(id);
    }
}