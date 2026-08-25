package com.oneteam.players.infrastructure.rest.dto;

public record CreatePlayerRequest(
        String name,
        String photoUrl,
        NationalityRequest nationality
) {
    public record NationalityRequest(
            String name,
            String isoCode,
            String flagUrl
    ) {}
}