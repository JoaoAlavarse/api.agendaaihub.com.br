package dev.alavarse.template.api.domain.exception.auth;

import dev.alavarse.template.api.shared.exception.ApiException;
import dev.alavarse.template.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends ApiException {

    public EmailAlreadyExistsException() {
        super(ErrorCodes.EMAIL_ALREADY_EXISTS, HttpStatus.BAD_REQUEST.value());
    }
}
