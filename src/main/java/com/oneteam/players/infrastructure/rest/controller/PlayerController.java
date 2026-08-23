package com.oneteam.players.infrastructure.rest.controller;

import com.oneteam.players.application.dto.PlayerResponseDto;
import com.oneteam.players.application.query.FindAllPlayersQuery;
import com.oneteam.players.application.query.FindAllPlayersQueryHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final FindAllPlayersQueryHandler findAllPlayersQueryHandler;

    public PlayerController(FindAllPlayersQueryHandler findAllPlayersQueryHandler) {
        this.findAllPlayersQueryHandler = findAllPlayersQueryHandler;
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
}