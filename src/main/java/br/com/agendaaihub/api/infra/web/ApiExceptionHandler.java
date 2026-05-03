package br.com.agendaaihub.api.infra.web;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import br.com.agendaaihub.api.shared.exception.ApiException;
import br.com.agendaaihub.api.shared.exception.ErrorCodes;
import br.com.agendaaihub.api.shared.exception.ProblemDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;

@RestControllerAdvice
public class ApiExceptionHandler {

    // =======================
    // ApiException (domínio)
    // =======================
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ProblemDetails> handleApiException(
            ApiException ex,
            HttpServletRequest request
    ) {
        var code = ex.getErrorCode();

        return response(
                request,
                code,
                HttpStatus.valueOf(ex.getHttpStatus()),
                ex.getMessage()
        );
    }

    // =======================
    // Missing / Validation
    // =======================
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ProblemDetails> missingHeader(
            MissingRequestHeaderException ex,
            HttpServletRequest request
    ) {
        return response(
                request,
                ErrorCodes.MISSING_HEADER,
                HttpStatus.BAD_REQUEST,
                "Header '%s' was not informed.".formatted(ex.getHeaderName())
        );
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ProblemDetails> missingField(
            MissingServletRequestParameterException ex,
            HttpServletRequest request
    ) {
        return response(
                request,
                ErrorCodes.FIELD_NOT_INFORMED,
                HttpStatus.BAD_REQUEST,
                "Field '%s' was not informed.".formatted(ex.getParameterName())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetails> validation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        FieldError error = ex.getBindingResult().getFieldError();

        String detail = error == null
                ? ErrorCodes.FIELD_VALIDATION.getDefaultDetail()
                : "Field '%s' validation failed: %s."
                .formatted(error.getField(), error.getDefaultMessage());

        return response(
                request,
                ErrorCodes.FIELD_VALIDATION,
                HttpStatus.BAD_REQUEST,
                detail
        );
    }

    // =======================
    // Type mismatch
    // =======================
    @ExceptionHandler({
            MethodArgumentTypeMismatchException.class,
            ConversionFailedException.class
    })
    public ResponseEntity<ProblemDetails> mismatch(
            Exception ex,
            HttpServletRequest request
    ) {
        return response(
                request,
                ErrorCodes.MISMATCH_VALUE,
                HttpStatus.BAD_REQUEST,
                ErrorCodes.MISMATCH_VALUE.getDefaultDetail()
        );
    }

    // =======================
    // JSON / Enum
    // =======================
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetails> unreadable(
            HttpMessageNotReadableException ex,
            HttpServletRequest request
    ) {
        if (ex.getCause() instanceof InvalidFormatException e
                && e.getTargetType().isEnum()) {

            var accepted = Arrays.stream(e.getTargetType().getEnumConstants())
                    .map(Object::toString)
                    .toList();

            return response(
                    request,
                    ErrorCodes.ENUMERATION_NOT_FOUND,
                    HttpStatus.BAD_REQUEST,
                    "Invalid enum value '%s'. Accepted values: %s."
                            .formatted(e.getValue(), accepted)
            );
        }

        return response(
                request,
                ErrorCodes.MISMATCH_VALUE,
                HttpStatus.BAD_REQUEST,
                ErrorCodes.MISMATCH_VALUE.getDefaultDetail()
        );
    }

    // =======================
    // Database
    // =======================
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ProblemDetails> integrity(
            HttpServletRequest request
    ) {
        return response(
                request,
                ErrorCodes.DATA_INTEGRITY_VIOLATION,
                HttpStatus.CONFLICT,
                ErrorCodes.DATA_INTEGRITY_VIOLATION.getDefaultDetail()
        );
    }

    // =======================
    // Builder
    // =======================
    private ResponseEntity<ProblemDetails> response(
            HttpServletRequest request,
            ErrorCodes code,
            HttpStatus status,
            String detail
    ) {
        return ResponseEntity.status(status).body(
                new ProblemDetails(
                        code.getTitle(),
                        status.value(),
                        detail,
                        request.getRequestURI(),
                        code
                )
        );
    }
}
