package dev.alavarse.template.api.shared.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApiException extends RuntimeException{
    private final ErrorCodes errorCode;
    private final int httpStatus;

    protected ApiException(ErrorCodes errorCode, int httpStatus) {
        super(errorCode.getDefaultDetail());
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    protected ApiException(ErrorCodes errorCode, int httpStatus, String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
