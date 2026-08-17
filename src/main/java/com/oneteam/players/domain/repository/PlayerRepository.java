package com.oneteam.players.domain.repository;

import com.oneteam.players.domain.model.Player;
import com.oneteam.players.domain.model.PlayerId;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    void save(Player player);
    Optional<Player> findById(PlayerId id);
    List<Player> findAll();
}