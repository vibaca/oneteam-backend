package com.oneteam.players.application.command;

public record CreatePlayerCommand(
        String name,
        String photoUrl,
        NationalityCommand nationality
) {
    public record NationalityCommand(
            String name,
            String isoCode,
            String flagUrl
    ) {}
}