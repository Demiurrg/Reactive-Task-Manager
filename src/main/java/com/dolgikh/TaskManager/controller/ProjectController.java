package com.dolgikh.TaskManager.controller;

import com.dolgikh.TaskManager.domain.Project;
import com.dolgikh.TaskManager.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Project>> getProjectById(@PathVariable UUID id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Mono<ResponseEntity<Project>> createProject(@RequestBody Project project) {
        return projectService.save(project)
                .map(savedProject -> ResponseEntity.status(HttpStatus.CREATED).body(savedProject));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Project>> updateProject(@PathVariable UUID id, @RequestBody Project project) {
        return projectService.update(id, project)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteProject(@PathVariable UUID id) {
        return projectService.delete(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
