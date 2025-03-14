package com.dolgikh.TaskManager.controller;

import com.dolgikh.TaskManager.domain.Task;
import com.dolgikh.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Task>> getById(@PathVariable UUID id) {
        return taskService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<Task> getAll() {
        return taskService.getAll();
    }

    @PostMapping
    public Mono<ResponseEntity<Task>> create(@RequestBody Task task) {
        return taskService.save(task)
                .map(savedTask -> ResponseEntity.status(HttpStatus.CREATED).body(savedTask));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Task>> update(@PathVariable UUID id, @RequestBody Task task) {
        return taskService.update(id, task)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable UUID id) {
        return taskService.delete(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
