package com.humanos.application.identity;

import com.humanos.domain.identity.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    boolean existsByEmail(String email);
}