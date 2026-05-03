package dev.alavarse.template.api.domain.exception.user;

import dev.alavarse.template.api.shared.exception.ApiException;
import dev.alavarse.template.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class UserNotActiveException extends ApiException {
    public UserNotActiveException() {
        super(ErrorCodes.USER_NOT_ACTIVE, HttpStatus.BAD_REQUEST.value());
    }
}
