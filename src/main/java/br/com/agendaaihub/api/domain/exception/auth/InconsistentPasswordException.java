package br.com.agendaaihub.api.domain.exception.auth;

import br.com.agendaaihub.api.shared.exception.ApiException;
import br.com.agendaaihub.api.shared.exception.ErrorCodes;
import org.springframework.http.HttpStatus;

public class InconsistentPasswordException extends ApiException {
    public InconsistentPasswordException() {
        super(ErrorCodes.INCONSISTENT_PASSWORD, HttpStatus.BAD_REQUEST.value());
    }
}
