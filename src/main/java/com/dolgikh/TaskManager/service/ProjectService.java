package com.dolgikh.TaskManager.service;

import com.dolgikh.TaskManager.domain.Project;
import com.dolgikh.TaskManager.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Mono<Project> getById(UUID id) {
        return projectRepository.findById(id);
    }

    public Flux<Project> getAll() {
        return projectRepository.findAll();
    }

    public Mono<Project> save(Project project) {
        return projectRepository.save(project);
    }

    public Mono<Project> update(UUID id, Project updatedProject) {
        return projectRepository.findById(id)
                .flatMap(_ -> {
                    Project newProject = new Project(
                            id,
                            updatedProject.name()
                    );
                    return projectRepository.save(newProject);
                });
    }

    public Mono<Void> delete(UUID id) {
        return projectRepository.deleteById(id);
    }
}
