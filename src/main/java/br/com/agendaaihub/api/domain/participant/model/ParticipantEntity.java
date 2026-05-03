package br.com.agendaaihub.api.domain.participant.model;

import br.com.agendaaihub.api.shared.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "participant")
@DynamicUpdate
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantEntity extends BaseEntity {
    @Length(min = 3, max = 255)
    @Column(nullable = false, updatable = false)
    private String name;

    @Email
    @Length(min = 3, max = 255)
    @Column(nullable = false, unique = true)
    private String email;

    @CPF
    @Length(min = 11, max = 11)
    @Column(nullable = false, updatable = false)
    private String document;

    @Length(min = 8, max = 11)
    @Column(nullable = true)
    private String phone;
}
