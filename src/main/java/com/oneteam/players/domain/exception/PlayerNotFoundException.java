package com.oneteam.players.domain.exception;

import com.oneteam.players.domain.model.PlayerId;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(PlayerId id) {
        super("Player with id " + id.value() + " was not found");
    }
}