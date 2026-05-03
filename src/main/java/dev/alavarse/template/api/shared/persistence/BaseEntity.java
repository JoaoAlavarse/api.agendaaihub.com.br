package dev.alavarse.template.api.shared.persistence;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.id.uuid.UuidVersion7Strategy;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id")
public abstract class BaseEntity {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @UuidGenerator(algorithm = UuidVersion7Strategy.class)
    @Getter
    private UUID id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private UUID createdBy;

    @LastModifiedBy
    private UUID lastModifiedBy;

    @Version
    private long version;
}
