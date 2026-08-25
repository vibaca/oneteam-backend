package com.oneteam.players.application.port.out;

import com.oneteam.players.domain.model.aggregate.Player;

public interface PlayerCommandOutputPort {

    /**
     * Persists a player aggregate into the database.
     *
     * @param player The player aggregate to save.
     * @return The saved player aggregate.
     */
    Player save(Player player);
}