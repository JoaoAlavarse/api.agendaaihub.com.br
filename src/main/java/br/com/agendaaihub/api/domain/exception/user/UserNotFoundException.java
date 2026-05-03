package br.com.agendaaihub.api.domain.exception.user;

import br.com.agendaaihub.api.shared.exception.ApiException;
import br.com.agendaaihub.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException() {
        super(ErrorCodes.USER_NOT_FOUND, HttpStatus.NOT_FOUND.value());
    }

    public UserNotFoundException(String message) {
        super(ErrorCodes.USER_NOT_FOUND, HttpStatus.NOT_FOUND.value(), message);
    }
}
