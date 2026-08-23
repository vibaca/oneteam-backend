package com.oneteam.players.infrastructure.persistence.adapter;

import com.oneteam.players.application.port.out.PlayerQueryOutputPort;
import com.oneteam.players.domain.model.aggregate.Player;
import com.oneteam.players.infrastructure.persistence.mapper.PlayerPersistenceMapper;
import com.oneteam.players.infrastructure.persistence.repository.SpringDataPlayerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerQueryJpaAdapter implements PlayerQueryOutputPort {

    private final SpringDataPlayerRepository repository;
    private final PlayerPersistenceMapper mapper;

    public PlayerQueryJpaAdapter(SpringDataPlayerRepository repository, PlayerPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}