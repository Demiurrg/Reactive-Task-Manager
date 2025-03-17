package com.dolgikh.TaskManager.service;

import com.dolgikh.TaskManager.domain.User;
import com.dolgikh.TaskManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    public Mono<User> getById(UUID id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(UUID id, User updatedUser) {
        return userRepository.findById(id)
                .flatMap(_ -> {
                    User newUser = new User(
                            id,
                            updatedUser.name()
                    );
                    return userRepository.save(newUser);
                });
    }

    public Mono<Void> delete(UUID id) {
        return userRepository.deleteById(id);
    }
}
