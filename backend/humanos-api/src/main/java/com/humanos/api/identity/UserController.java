package com.humanos.api.identity;

import com.humanos.application.identity.RegisterUserUseCase;
import com.humanos.application.identity.GetUserUseCase;
import com.humanos.domain.identity.User;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UserController(
            RegisterUserUseCase registerUserUseCase,
            GetUserUseCase getUserUseCase
    ) {
        this.registerUserUseCase = registerUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public UserResponse register(@RequestBody @Valid RegisterUserRequest request) {
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

    @GetMapping("/{id}")
    public UserResponse getUser(
            @PathVariable UUID id
    ) {
        User user = getUserUseCase.execute(id);

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}