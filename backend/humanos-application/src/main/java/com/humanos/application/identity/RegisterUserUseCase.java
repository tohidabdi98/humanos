package com.humanos.application.identity;

import com.humanos.domain.identity.User;

public class RegisterUserUseCase {
    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String username, String email) {
        User user = User.create(username, email);
        return userRepository.save(user);
    }
}