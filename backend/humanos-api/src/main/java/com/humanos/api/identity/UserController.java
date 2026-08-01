package com.humanos.api.identity;

import com.humanos.application.identity.RegisterUserUseCase;
import com.humanos.domain.identity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    public UserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping
    public UserResponse register(@RequestBody RegisterUserRequest request) {
        User user =
                registerUserUseCase.execute(
                        request.username(),
                        request.email()
                );

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}