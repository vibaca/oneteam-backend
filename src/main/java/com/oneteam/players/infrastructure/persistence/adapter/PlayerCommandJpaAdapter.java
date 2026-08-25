package com.oneteam.players.infrastructure.persistence.adapter;

import com.oneteam.players.application.port.out.PlayerCommandOutputPort;
import com.oneteam.players.domain.model.aggregate.Player;
import com.oneteam.players.infrastructure.persistence.mapper.PlayerPersistenceMapper;
import com.oneteam.players.infrastructure.persistence.repository.SpringDataPlayerRepository;
import org.springframework.stereotype.Component;

@Component
public class PlayerCommandJpaAdapter implements PlayerCommandOutputPort {

    private final SpringDataPlayerRepository repository;
    private final PlayerPersistenceMapper mapper;

    public PlayerCommandJpaAdapter(SpringDataPlayerRepository repository, PlayerPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Player save(Player player) {
        var entity = mapper.toEntity(player);
        var savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }
}