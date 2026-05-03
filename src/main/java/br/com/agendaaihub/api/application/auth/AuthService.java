package br.com.agendaaihub.api.application.auth;

import br.com.agendaaihub.api.application.auth.dto.input.LoginRequestDto;
import br.com.agendaaihub.api.application.auth.dto.input.UserRegisterRequestDto;
import br.com.agendaaihub.api.application.auth.dto.output.AuthResponseDto;

public interface AuthService {
    AuthResponseDto register(UserRegisterRequestDto body);
    AuthResponseDto login(LoginRequestDto body);
}
