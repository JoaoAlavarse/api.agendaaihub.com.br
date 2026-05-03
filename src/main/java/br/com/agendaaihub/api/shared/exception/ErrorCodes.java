package br.com.agendaaihub.api.shared.exception;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ErrorCodes {

    UNEXPECTED_ERROR(
            "ERR_0000",
            "Unexpected error",
            "An unexpected error occurred"
    ),

    MISMATCH_VALUE(
            "ERR_0001",
            "Invalid value",
            "The provided value is invalid"
    ),

    FIELD_NOT_INFORMED(
            "ERR_0002",
            "Missing field",
            "A required field was not informed"
    ),

    DATA_INTEGRITY_VIOLATION(
            "ERR_0003",
            "Database integrity violation",
            "A database integrity violation occurred"
    ),

    ENUMERATION_NOT_FOUND(
            "ERR_0004",
            "Invalid enum value",
            "The provided enum value is invalid"
    ),

    MISSING_HEADER(
            "ERR_0005",
            "Missing header",
            "A required header was not informed"
    ),

    FIELD_VALIDATION(
            "ERR_0006",
            "Validation failed",
            "One or more fields failed validation"
    ),

    INVALID_LOGIN(
            "ERR_0007",
            "Invalid login",
            "Email or password is incorrect"
    ),

    USER_NOT_FOUND(
            "ERR_0008",
            "User not found",
            "The specified user could not be found"
    ),

    INCONSISTENT_PASSWORD(
            "ERR_0009",
            "Inconsistent passwords",
            "The passwords given dit not matched"
    ),

    EMAIL_ALREADY_EXISTS(
            "ERR_0010",
            "Email already exists",
            "The given email already exists in the database"
    ),

    USER_NOT_ACTIVE(
            "ERR_0011",
            "User not active",
            "The given user is not active"
    );

    private final String code;
    private final String title;
    private final String defaultDetail;

    ErrorCodes(String code, String title, String defaultDetail) {
        this.code = code;
        this.title = title;
        this.defaultDetail = defaultDetail;
    }

    @JsonValue
    public String value() {
        return code;
    }
}
