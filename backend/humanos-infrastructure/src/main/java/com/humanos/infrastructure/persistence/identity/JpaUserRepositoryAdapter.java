package com.humanos.infrastructure.persistence.identity;

import com.humanos.application.identity.UserRepository;
import com.humanos.domain.identity.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository repository;

    public JpaUserRepositoryAdapter(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {

        UserEntity entity = new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );

        UserEntity saved = repository.save(entity);

        return User.reconstruct(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail()
        );
    }

    @Override
    public Optional<User> findById(UUID id) {

        return repository.findById(id)
                .map(entity ->
                        User.reconstruct(
                                entity.getId(),
                                entity.getUsername(),
                                entity.getEmail()
                        )
                );
    }
}