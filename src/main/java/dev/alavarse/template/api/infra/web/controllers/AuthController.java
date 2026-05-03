package dev.alavarse.template.api.infra.web.controllers;

import dev.alavarse.template.api.application.auth.AuthService;
import dev.alavarse.template.api.application.auth.dto.input.LoginRequestDto;
import dev.alavarse.template.api.application.auth.dto.input.UserRegisterRequestDto;
import dev.alavarse.template.api.application.auth.dto.output.AuthResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        return ResponseEntity.ok(authService.register(userRegisterRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }
}
