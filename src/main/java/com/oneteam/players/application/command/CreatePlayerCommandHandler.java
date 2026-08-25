package com.oneteam.players.application.command;

import com.oneteam.players.application.dto.PlayerResponseDto;
import com.oneteam.players.application.mapper.PlayerResponseMapper;
import com.oneteam.players.application.port.in.CreatePlayerUseCase;
import com.oneteam.players.application.port.out.PlayerCommandOutputPort;
import com.oneteam.players.domain.model.aggregate.Player;
import com.oneteam.players.domain.model.valueobjects.Nationality;
import com.oneteam.players.domain.model.valueobjects.PhotoUrl;
import com.oneteam.players.domain.model.valueobjects.PlayerName;

public class CreatePlayerCommandHandler implements CreatePlayerUseCase {

    private final PlayerCommandOutputPort playerCommandOutputPort;
    private final PlayerResponseMapper playerResponseMapper;

    public CreatePlayerCommandHandler(
            PlayerCommandOutputPort playerCommandOutputPort,
            PlayerResponseMapper playerResponseMapper
    ) {
        this.playerCommandOutputPort = playerCommandOutputPort;
        this.playerResponseMapper = playerResponseMapper;
    }

    @Override
    public PlayerResponseDto create(CreatePlayerCommand command) {
        // 1. Transformamos los datos primitivos del comando en Value Objects del dominio
        var playerName = new PlayerName(command.name());
        var photoUrl = new PhotoUrl(command.photoUrl());

        var nationalityDto = command.nationality();
        var nationality = new Nationality(
                nationalityDto.name(),
                nationalityDto.isoCode(),
                nationalityDto.flagUrl()
        );

        // 2. Creamos el agregado de dominio usando el método de fábrica
        var player = Player.create(playerName, photoUrl, nationality);

        // 3. Persistimos a través del puerto de salida
        var savedPlayer = playerCommandOutputPort.save(player);

        // 4. Mapeamos el resultado a DTO y lo devolvemos
        return playerResponseMapper.toDto(savedPlayer);
    }
}