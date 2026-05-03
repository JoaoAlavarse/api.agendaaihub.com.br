package br.com.agendaaihub.api.domain.user.repository;

import br.com.agendaaihub.api.domain.user.model.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
    Optional<UserEntity> findById(UUID id);
    UserEntity save(UserEntity user);
}

