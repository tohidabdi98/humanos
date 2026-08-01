package com.humanos.domain.identity;

import java.util.UUID;

public class User {
    private final UUID id;
    private String username;
    private String email;

    private User(
            UUID id,
            String username,
            String email
    ) {

        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException(
                    "Username cannot be empty"
            );
        }

        if(email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be empty"
            );
        }

        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public static User create(
            String username,
            String email
    ) {
        return new User(
                UUID.randomUUID(),
                username,
                email
        );
    }

    public static User reconstruct(
            UUID id,
            String username,
            String email
    ) {
        return new User(id, username, email);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}