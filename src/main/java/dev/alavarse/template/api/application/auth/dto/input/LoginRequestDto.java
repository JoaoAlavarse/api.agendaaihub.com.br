package dev.alavarse.template.api.application.auth.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record LoginRequestDto(
        @Email
        String email,
        @Size(min = 8)
        String password
) {
}
