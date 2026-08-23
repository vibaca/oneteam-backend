package com.oneteam.players.application.dto;

public record PlayerResponseDto(
        String id,
        String name,
        String photoUrl,
        NationalityResponse nationality
) {
    public record NationalityResponse(
            String name,
            String isoCode,
            String flagUrl
    ) {}
}