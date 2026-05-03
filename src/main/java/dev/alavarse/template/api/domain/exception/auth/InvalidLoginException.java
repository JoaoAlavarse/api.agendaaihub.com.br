package dev.alavarse.template.api.domain.exception.auth;

import dev.alavarse.template.api.shared.exception.ApiException;
import dev.alavarse.template.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class InvalidLoginException extends ApiException {
    public InvalidLoginException() {
        super(ErrorCodes.INVALID_LOGIN, HttpStatus.BAD_REQUEST.value());
    }

    public InvalidLoginException(String message) {
        super(ErrorCodes.INVALID_LOGIN, HttpStatus.BAD_REQUEST.value(), message);
    }
}
