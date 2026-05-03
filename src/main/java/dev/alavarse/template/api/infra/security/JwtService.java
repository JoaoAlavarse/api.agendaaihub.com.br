package dev.alavarse.template.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.alavarse.template.api.domain.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier verifier;

    public JwtService(@Value("${security.jwt.secret}") String secret) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algorithm).build();
    }

    public String generateToken(UserEntity user) {
        Instant now = Instant.now();

        return JWT.create()
                .withSubject(user.getId().toString())
                .withClaim("role", user.getRole().toString())
                .withIssuedAt(now)
                .withExpiresAt(now.plusSeconds(60 * 60 * 24)) // 24h
                .sign(algorithm);
    }

    public DecodedJWT validate(String token) {
        return verifier.verify(token);
    }

    public UUID getUserId(DecodedJWT jwt) {
        return UUID.fromString(jwt.getSubject());
    }

    public String getRole(DecodedJWT jwt) {
        return jwt.getClaim("role").asString();
    }
}
