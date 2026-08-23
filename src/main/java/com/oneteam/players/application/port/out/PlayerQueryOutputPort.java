package com.oneteam.players.application.port.out;

import com.oneteam.players.domain.model.aggregate.Player;
import java.util.List;

public interface PlayerQueryOutputPort {

    /**
     * Retrieves all players registered in the system.
     *
     * @return A list of all player aggregates.
     */
    List<Player> findAll();
}
