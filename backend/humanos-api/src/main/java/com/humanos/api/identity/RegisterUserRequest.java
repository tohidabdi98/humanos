package com.humanos.api.identity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(
        @NotBlank(message = "Username is required")
        @Size(
                min = 3,
                max = 30,
                message = "Username must be between 3 and 30 characters"
        )
        String username,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email
) {
}