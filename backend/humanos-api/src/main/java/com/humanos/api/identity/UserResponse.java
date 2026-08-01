package com.humanos.api.identity;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email
) {
}