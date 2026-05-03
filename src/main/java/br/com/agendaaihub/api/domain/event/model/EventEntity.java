package br.com.agendaaihub.api.domain.event.model;

import br.com.agendaaihub.api.shared.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;

@Entity
@Table(name = "event")
@DynamicUpdate
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity extends BaseEntity {
    @Length(min = 3, max = 255)
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @FutureOrPresent
    private Instant startDate;

    @Column(nullable = false)
    @FutureOrPresent
    private Instant endDate;
}
