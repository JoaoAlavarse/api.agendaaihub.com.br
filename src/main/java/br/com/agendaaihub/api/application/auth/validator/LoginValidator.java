package br.com.agendaaihub.api.application.auth.validator;

import br.com.agendaaihub.api.application.auth.dto.input.LoginRequestDto;
import br.com.agendaaihub.api.domain.exception.auth.InvalidLoginException;
import br.com.agendaaihub.api.domain.exception.user.UserNotActiveException;
import br.com.agendaaihub.api.domain.user.model.UserEntity;
import br.com.agendaaihub.api.domain.user.model.UserStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginValidator {

    private final PasswordEncoder passwordEncoder;

    public LoginValidator(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void validate(LoginRequestDto dto, UserEntity user) {
        this.validatePassword(dto.password(), user.getPassword());
        this.validateStatus(user.getStatus());
    }

    private void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new InvalidLoginException();
        }
    }

    private void validateStatus(UserStatus userStatus) {
        if (!userStatus.equals(UserStatus.ACTIVE)) {
            throw new UserNotActiveException();
        }
    }
}
