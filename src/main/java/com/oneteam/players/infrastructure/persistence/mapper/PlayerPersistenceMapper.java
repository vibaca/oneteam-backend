package com.oneteam.players.infrastructure.persistence.mapper;

import com.oneteam.players.domain.model.aggregate.Player;
import com.oneteam.players.domain.model.valueobjects.Nationality;
import com.oneteam.players.domain.model.valueobjects.PhotoUrl;
import com.oneteam.players.domain.model.valueobjects.PlayerId;
import com.oneteam.players.domain.model.valueobjects.PlayerName;
import com.oneteam.players.infrastructure.persistence.entity.PlayerEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlayerPersistenceMapper {

    public Player toDomain(PlayerEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Player(
                new PlayerId(UUID.fromString(entity.getId())),
                new PlayerName(entity.getName()),
                new PhotoUrl(entity.getPhotoUrl()),
                new Nationality(entity.getNationalityName(), entity.getIsoCode(), entity.getFlagUrl())
        );
    }

    public PlayerEntity toEntity(Player player) {
        if (player == null) {
            return null;
        }

        var nationality = player.getNationality();

        return new PlayerEntity(
                player.getId().value().toString(),
                player.getName().value(),
                player.getPhotoUrl().valueOrNull(),
                nationality.name(),
                nationality.isoCode(),
                nationality.flagUrl()
        );
    }
}