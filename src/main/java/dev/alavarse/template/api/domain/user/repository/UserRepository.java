package dev.alavarse.template.api.domain.user.repository;

import dev.alavarse.template.api.domain.user.model.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
    Optional<UserEntity> findById(UUID id);
    UserEntity save(UserEntity user);
}

