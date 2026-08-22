package com.oneteam.players.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record PlayerId(UUID value) {
    public PlayerId {
        Objects.requireNonNull(value, "PlayerId cannot be null");
    }

    public static PlayerId generate() {
        return new PlayerId(UUID.randomUUID());
    }

    public static PlayerId of(String uuidString) {
        return new PlayerId(UUID.fromString(uuidString));
    }
}