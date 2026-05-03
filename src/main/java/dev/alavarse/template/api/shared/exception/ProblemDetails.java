package dev.alavarse.template.api.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {

    // RFC 7807
    private String title;      // Resumo curto e estável
    private Integer status;    // HTTP status
    private String detail;     // Descrição detalhada
    private String instance;   // Path da requisição

    // API contract
    private ErrorCodes apiCode; // serializa como string via @JsonValue
}
