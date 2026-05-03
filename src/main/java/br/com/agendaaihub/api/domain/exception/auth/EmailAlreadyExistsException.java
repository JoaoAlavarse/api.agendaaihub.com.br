package br.com.agendaaihub.api.domain.exception.auth;

import br.com.agendaaihub.api.shared.exception.ApiException;
import br.com.agendaaihub.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends ApiException {

    public EmailAlreadyExistsException() {
        super(ErrorCodes.EMAIL_ALREADY_EXISTS, HttpStatus.BAD_REQUEST.value());
    }
}
