package com.oneteam.players.infrastructure.rest.controller;

import com.oneteam.players.application.command.CreatePlayerCommand;
import com.oneteam.players.application.dto.PlayerResponseDto;
import com.oneteam.players.application.port.in.CreatePlayerUseCase;
import com.oneteam.players.application.query.FindAllPlayersQuery;
import com.oneteam.players.application.query.FindAllPlayersQueryHandler;
import com.oneteam.players.infrastructure.rest.dto.CreatePlayerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final FindAllPlayersQueryHandler findAllPlayersQueryHandler;
    private final CreatePlayerUseCase createPlayerUseCase;

    public PlayerController(
            FindAllPlayersQueryHandler findAllPlayersQueryHandler,
            CreatePlayerUseCase createPlayerUseCase
    ) {
        this.findAllPlayersQueryHandler = findAllPlayersQueryHandler;
        this.createPlayerUseCase = createPlayerUseCase;
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseDto>> findAllPlayers() {
        // 1. Creamos la query (vacía por ahora para traer todos)
        FindAllPlayersQuery query = new FindAllPlayersQuery();

        // 2. Ejecutamos el handler que devuelve los DTOs listos
        List<PlayerResponseDto> players = findAllPlayersQueryHandler.handle(query);

        // 3. Retornamos la respuesta HTTP 200 OK con los datos
        return ResponseEntity.ok(players);
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDto> createPlayer(@RequestBody CreatePlayerRequest request) {
        // 1. Convertimos el DTO de la petición HTTP en el Command de application
        var nationality = request.nationality();
        var command = new CreatePlayerCommand(
                request.name(),
                request.photoUrl(),
                new CreatePlayerCommand.NationalityCommand(
                        nationality.name(),
                        nationality.isoCode(),
                        nationality.flagUrl()
                )
        );

        // 2. Ejecutamos el caso de uso, que devuelve el DTO ya listo
        PlayerResponseDto createdPlayer = createPlayerUseCase.create(command);

        // 3. Retornamos 201 Created con el recurso creado
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdPlayer);
    }
}