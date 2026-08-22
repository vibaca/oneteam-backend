package com.oneteam.players.application.query;

import com.oneteam.players.domain.model.aggregate.Player;
import com.oneteam.players.domain.repository.PlayerRepository;
import java.util.List;

public class FindAllPlayersQueryHandler {

    private final PlayerRepository repository;

    // Inyección de dependencia (por constructor)
    public FindAllPlayersQueryHandler(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> handle(FindAllPlayersQuery query) {
        // Aquí podrías agregar lógica de aplicación, como logs o transformación de datos
        return repository.findAll();
    }
}