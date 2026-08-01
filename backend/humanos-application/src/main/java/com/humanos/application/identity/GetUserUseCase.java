package com.humanos.application.identity;

import com.humanos.domain.identity.User;
import java.util.UUID;

public class GetUserUseCase {

    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found: " + id
                        )
                );
    }
}