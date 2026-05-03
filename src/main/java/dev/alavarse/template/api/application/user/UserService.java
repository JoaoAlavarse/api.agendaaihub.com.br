package dev.alavarse.template.api.application.user;

import dev.alavarse.template.api.application.auth.dto.input.UserRegisterRequestDto;
import dev.alavarse.template.api.domain.user.model.UserEntity;

import java.util.UUID;

public interface UserService {
    UserEntity save(UserEntity body);
    UserEntity save(UserRegisterRequestDto body);
    UserEntity findById(UUID id);
    UserEntity findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
}
