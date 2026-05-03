package dev.alavarse.template.api.application.auth;

import dev.alavarse.template.api.application.auth.dto.input.LoginRequestDto;
import dev.alavarse.template.api.application.auth.dto.input.UserRegisterRequestDto;
import dev.alavarse.template.api.application.auth.dto.output.AuthResponseDto;
import dev.alavarse.template.api.application.auth.validator.LoginValidator;
import dev.alavarse.template.api.application.auth.validator.UserRegisterValidator;
import dev.alavarse.template.api.application.user.UserService;
import dev.alavarse.template.api.domain.user.model.UserEntity;
import dev.alavarse.template.api.domain.user.model.UserRoles;
import dev.alavarse.template.api.domain.user.model.UserStatus;
import dev.alavarse.template.api.infra.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRegisterValidator registerValidator;
    private final LoginValidator loginValidator;

    @Override
    public AuthResponseDto register(UserRegisterRequestDto body) {
        this.registerValidator.validate(body);

        UserEntity userEntity = UserEntity.builder()
                .name(body.name())
                .email(body.email())
                .password(passwordEncoder.encode(body.password()))
                .role(UserRoles.ADMIN).status(UserStatus.ACTIVE)
                .build();

        this.userService.save(userEntity);

        String token = jwtService.generateToken(userEntity);

        return new AuthResponseDto(token);
    }

    @Override
    public AuthResponseDto login(LoginRequestDto body) {
        UserEntity userEntity = this.userService.findByEmailIgnoreCase(body.email());

        this.loginValidator.validate(body, userEntity);

        String token = jwtService.generateToken(userEntity);
        return new AuthResponseDto(token);
    }
}
