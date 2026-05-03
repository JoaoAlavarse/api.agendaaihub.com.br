package br.com.agendaaihub.api.domain.user.model;

import br.com.agendaaihub.api.shared.persistence.BaseEntity;
import br.com.agendaaihub.api.shared.persistence.SoftDelete;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
@DynamicUpdate
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    @Length(min = 3, max = 255)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    @Length(min = 3, max = 255)
    private String email;

    @Column(nullable = false)
    @Length(min = 3, max = 255)
    private String password;

    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Embedded
    @Builder.Default
    private SoftDelete softDelete = new SoftDelete();
}
