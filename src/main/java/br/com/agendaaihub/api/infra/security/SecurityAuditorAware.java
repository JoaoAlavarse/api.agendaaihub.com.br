package br.com.agendaaihub.api.infra.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class SecurityAuditorAware implements AuditorAware<UUID> {

    private static final UUID SYSTEM_USER = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private final JwtService jwtService;

    public SecurityAuditorAware(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Optional<UUID> getCurrentAuditor() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) return Optional.of(SYSTEM_USER);

        Object principal = auth.getPrincipal();

        if (principal instanceof DecodedJWT jwt) {
            return Optional.of(jwtService.getUserId(jwt));
        }

        return Optional.of(SYSTEM_USER);
    }
}
