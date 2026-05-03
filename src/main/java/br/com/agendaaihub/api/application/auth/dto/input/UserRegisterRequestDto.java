package br.com.agendaaihub.api.application.auth.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterRequestDto(
        @Email
        String email,
        @Size(min = 8)
        String password,
        @Size(min = 8)
        String confirmPassword,
        @Size(min = 3)
        @NotBlank
        String name
) {
}
