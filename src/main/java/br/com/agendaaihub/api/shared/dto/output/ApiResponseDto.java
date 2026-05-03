package br.com.agendaaihub.api.shared.dto.output;

import java.util.Optional;
import java.util.UUID;

public record ApiResponseDto(
        Optional<UUID> resourceId
) {
}
