package br.com.agendaaihub.api.domain.exception.user;

import br.com.agendaaihub.api.shared.exception.ApiException;
import br.com.agendaaihub.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class UserNotActiveException extends ApiException {
    public UserNotActiveException() {
        super(ErrorCodes.USER_NOT_ACTIVE, HttpStatus.BAD_REQUEST.value());
    }
}
