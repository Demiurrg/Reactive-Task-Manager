package com.dolgikh.TaskManager.repository;

import com.dolgikh.TaskManager.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
}
