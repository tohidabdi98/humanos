package com.humanos.api.health;

public record HealthResponse(
        String status,
        String application,
        String version
) {}
