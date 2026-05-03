package br.com.agendaaihub.api.domain.exception.auth;

import br.com.agendaaihub.api.shared.exception.ApiException;
import br.com.agendaaihub.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class InvalidLoginException extends ApiException {
    public InvalidLoginException() {
        super(ErrorCodes.INVALID_LOGIN, HttpStatus.BAD_REQUEST.value());
    }

    public InvalidLoginException(String message) {
        super(ErrorCodes.INVALID_LOGIN, HttpStatus.BAD_REQUEST.value(), message);
    }
}
