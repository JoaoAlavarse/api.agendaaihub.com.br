package dev.alavarse.template.api.application.auth;

import dev.alavarse.template.api.application.auth.dto.input.LoginRequestDto;
import dev.alavarse.template.api.application.auth.dto.input.UserRegisterRequestDto;
import dev.alavarse.template.api.application.auth.dto.output.AuthResponseDto;

public interface AuthService {
    AuthResponseDto register(UserRegisterRequestDto body);
    AuthResponseDto login(LoginRequestDto body);
}
