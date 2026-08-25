package com.oneteam.players.application.port.in;

import com.oneteam.players.application.command.CreatePlayerCommand;
import com.oneteam.players.application.dto.PlayerResponseDto;

public interface CreatePlayerUseCase {

    /**
     * Registers a new player in the system.
     *
     * @param command The command containing the player's data.
     * @return The response DTO of the created player.
     */
    PlayerResponseDto create(CreatePlayerCommand command);
}