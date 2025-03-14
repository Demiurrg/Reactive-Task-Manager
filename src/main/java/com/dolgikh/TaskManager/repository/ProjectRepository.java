package com.dolgikh.TaskManager.repository;

import com.dolgikh.TaskManager.domain.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface ProjectRepository extends ReactiveCrudRepository<Project, UUID> {

}
