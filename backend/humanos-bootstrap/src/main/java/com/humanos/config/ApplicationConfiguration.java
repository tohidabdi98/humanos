package com.humanos.config;

import com.humanos.application.identity.RegisterUserUseCase;
import com.humanos.application.identity.UserRepository;
import com.humanos.application.identity.GetUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RegisterUserUseCase registerUserUseCase(
            UserRepository userRepository
    ) {
        return new RegisterUserUseCase(userRepository);
    }

    @Bean
    public GetUserUseCase getUserUseCase(
            UserRepository userRepository
    ) {
        return new GetUserUseCase(userRepository);
    }
}