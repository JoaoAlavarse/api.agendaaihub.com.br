package br.com.agendaaihub.api.infra.persistence.user;

import br.com.agendaaihub.api.domain.user.model.UserEntity;
import br.com.agendaaihub.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaRepository;

    @Override
    public Optional<UserEntity> findByEmailIgnoreCase(String email) {
        return jpaRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public boolean existsByEmailIgnoreCase(String email) {
        return jpaRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return jpaRepository.save(user);
    }
}
