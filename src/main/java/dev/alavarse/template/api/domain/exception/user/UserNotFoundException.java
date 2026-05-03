package dev.alavarse.template.api.domain.exception.user;

import dev.alavarse.template.api.shared.exception.ApiException;
import dev.alavarse.template.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException() {
        super(ErrorCodes.USER_NOT_FOUND, HttpStatus.NOT_FOUND.value());
    }

    public UserNotFoundException(String message) {
        super(ErrorCodes.USER_NOT_FOUND, HttpStatus.NOT_FOUND.value(), message);
    }
}
