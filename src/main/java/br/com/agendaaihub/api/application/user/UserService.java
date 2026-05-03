package br.com.agendaaihub.api.application.user;

import br.com.agendaaihub.api.application.auth.dto.input.UserRegisterRequestDto;
import br.com.agendaaihub.api.domain.user.model.UserEntity;

import java.util.UUID;

public interface UserService {
    UserEntity save(UserEntity body);
    UserEntity save(UserRegisterRequestDto body);
    UserEntity findById(UUID id);
    UserEntity findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
}
