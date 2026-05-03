package dev.alavarse.template.api.application.user;

import dev.alavarse.template.api.application.auth.dto.input.UserRegisterRequestDto;
import dev.alavarse.template.api.domain.exception.user.UserNotFoundException;
import dev.alavarse.template.api.domain.user.model.UserEntity;
import dev.alavarse.template.api.domain.user.model.UserRoles;
import dev.alavarse.template.api.domain.user.model.UserStatus;
import dev.alavarse.template.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity body) {
        return this.userRepository.save(body);
    }

    @Override
    public UserEntity save(UserRegisterRequestDto body) {
        UserEntity userEntity = UserEntity.builder()
                .name(body.name())
                .email(body.email())
                .password(body.password())
                .role(UserRoles.USER)
                .status(UserStatus.ACTIVE)
                .build();
        return this.userRepository.save(userEntity);
    }

    @Override
    public UserEntity findById(UUID id) {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserEntity findByEmailIgnoreCase(String email) {
        return this.userRepository.findByEmailIgnoreCase(email).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public boolean existsByEmailIgnoreCase(String email) {
        return this.userRepository.existsByEmailIgnoreCase(email);
    }
}
