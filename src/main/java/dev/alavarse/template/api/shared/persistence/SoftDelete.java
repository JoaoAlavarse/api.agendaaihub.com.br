package dev.alavarse.template.api.shared.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Embeddable
@Getter
public class SoftDelete {

    @Column(nullable = false)
    private boolean deleted = false;

    private OffsetDateTime deletedAt;

    private UUID deletedBy;

    public void markDeleted(UUID userId) {
        this.deleted = true;
        this.deletedAt = OffsetDateTime.now();
        this.deletedBy = userId;
    }
}
