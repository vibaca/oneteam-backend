package com.oneteam.players.domain.model.valueobjects;

import java.util.Objects;

public record Nationality(
        String name,
        String isoCode,
        String flagUrl
) {
    public Nationality {
        Objects.requireNonNull(name, "Nationality name cannot be null");
        Objects.requireNonNull(isoCode, "ISO code cannot be null");
        if (isoCode.isBlank()) {
            throw new IllegalArgumentException("ISO code cannot be blank");
        }
    }
}