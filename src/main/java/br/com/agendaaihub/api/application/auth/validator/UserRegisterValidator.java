package br.com.agendaaihub.api.application.auth.validator;

import br.com.agendaaihub.api.application.auth.dto.input.UserRegisterRequestDto;
import br.com.agendaaihub.api.application.user.UserService;
import br.com.agendaaihub.api.domain.exception.auth.EmailAlreadyExistsException;
import br.com.agendaaihub.api.domain.exception.auth.InconsistentPasswordException;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterValidator {

    private final UserService userService;

    public UserRegisterValidator(UserService userService) {
        this.userService = userService;
    }

    public void validate(UserRegisterRequestDto dto) {
        validatePasswords(dto.password(), dto.confirmPassword());
        validateEmailUnique(dto.email());
    }

    private void validatePasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new InconsistentPasswordException();
        }
    }

    private void validateEmailUnique(String email) {
        if (userService.existsByEmailIgnoreCase(email)) {
            throw new EmailAlreadyExistsException();

        }
    }
}