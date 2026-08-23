package com.oneteam.players.application.query;

import com.oneteam.players.application.dto.PlayerResponseDto;
import com.oneteam.players.application.mapper.PlayerResponseMapper;
import com.oneteam.players.application.port.out.PlayerQueryOutputPort;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllPlayersQueryHandler {

    private final PlayerQueryOutputPort playerQueryOutputPort;
    private final PlayerResponseMapper playerResponseMapper;

    // Inyección de dependencias por constructor
    public FindAllPlayersQueryHandler(
            PlayerQueryOutputPort playerQueryOutputPort,
            PlayerResponseMapper playerResponseMapper
    ) {
        this.playerQueryOutputPort = playerQueryOutputPort;
        this.playerResponseMapper = playerResponseMapper;
    }

    public List<PlayerResponseDto> handle(FindAllPlayersQuery query) {
        // 1. Obtenemos las entidades de dominio desde el puerto de salida
        var players = playerQueryOutputPort.findAll();

        // 2. Mapeamos las entidades de dominio a DTOs usando el mapper
        return players.stream()
                .map(playerResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}