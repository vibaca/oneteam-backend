package com.oneteam.players.application.mapper;

import com.oneteam.players.application.dto.PlayerResponseDto;
import com.oneteam.players.domain.model.aggregate.Player;
import com.oneteam.players.domain.model.valueobjects.Nationality;
import com.oneteam.players.domain.model.valueobjects.PhotoUrl;
import com.oneteam.players.domain.model.valueobjects.PlayerId;
import com.oneteam.players.domain.model.valueobjects.PlayerName;
import org.springframework.stereotype.Component;

@Component
public class PlayerResponseMapper {

    public PlayerResponseDto toDto(Player player) {
        if (player == null) {
            return null;
        }

        return new PlayerResponseDto(
                valueOf(player.getId()),
                valueOf(player.getName()),
                valueOf(player.getPhotoUrl()),
                toNationalityResponse(player.getNationality())
        );
    }

    private static String valueOf(PlayerId id) {
        return id == null ? null : id.value().toString();
    }

    private static String valueOf(PlayerName name) {
        return name == null ? null : name.value();
    }

    private static String valueOf(PhotoUrl photoUrl) {
        return photoUrl == null ? null : photoUrl.value();
    }

    private static PlayerResponseDto.NationalityResponse toNationalityResponse(Nationality nationality) {
        if (nationality == null) {
            return null;
        }
        return new PlayerResponseDto.NationalityResponse(
                nationality.name(),
                nationality.isoCode(),
                nationality.flagUrl()
        );
    }
}