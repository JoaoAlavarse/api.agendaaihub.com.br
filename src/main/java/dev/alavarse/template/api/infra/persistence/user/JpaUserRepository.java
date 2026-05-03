package dev.alavarse.template.api.infra.persistence.user;

import dev.alavarse.template.api.domain.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
}
