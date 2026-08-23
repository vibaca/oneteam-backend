package com.oneteam.players.application.port.in;

import com.oneteam.players.application.dto.PlayerResponseDto;
import com.oneteam.players.application.query.FindAllPlayersQuery;

import java.util.List;

public interface FindAllPlayersUseCase {

    /**
     * Retrieves all players registered in the system based on the query parameters.
     *
     * @param query The query object containing filters, pagination, or sorting criteria.
     * @return A list of player DTOs.
     */
    List<PlayerResponseDto> findAll(FindAllPlayersQuery query);
}