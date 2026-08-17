package com.oneteam.players.domain.model;

public record PhotoUrl(String value) {
    public PhotoUrl {
        if (value != null) {
            String trimmed = value.trim();
            if (trimmed.isBlank()) {
                throw new IllegalArgumentException("Photo URL cannot be blank if provided");
            }
        }
    }

    public String valueOrNull() {
        return value != null ? value.trim() : null;
    }
}