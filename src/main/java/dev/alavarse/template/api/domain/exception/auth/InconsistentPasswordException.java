package dev.alavarse.template.api.domain.exception.auth;

import dev.alavarse.template.api.shared.exception.ApiException;
import dev.alavarse.template.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class InconsistentPasswordException extends ApiException {
    public InconsistentPasswordException() {
        super(ErrorCodes.INCONSISTENT_PASSWORD, HttpStatus.BAD_REQUEST.value());
    }
}
