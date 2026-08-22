package com.oneteam.players.domain.model.valueobjects;

import java.util.Objects;

public record PlayerName(String value) {
    public PlayerName {
        Objects.requireNonNull(value, "Player name cannot be null");
        String trimmed = value.trim();
        if (trimmed.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be blank");
        }
        if (trimmed.length() < 2) {
            throw new IllegalArgumentException("Player name must be at least 2 characters long");
        }
    }

    @Override
    public String toString() {
        return value.trim();
    }
}