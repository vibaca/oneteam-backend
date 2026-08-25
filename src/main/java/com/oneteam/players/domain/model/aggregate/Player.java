package com.oneteam.players.domain.model.aggregate;

import com.oneteam.players.domain.model.valueobjects.Nationality;
import com.oneteam.players.domain.model.valueobjects.PhotoUrl;
import com.oneteam.players.domain.model.valueobjects.PlayerId;
import com.oneteam.players.domain.model.valueobjects.PlayerName;

import java.util.UUID;
import java.util.Objects;

public class Player {
    private final PlayerId id;
    private PlayerName name;
    private PhotoUrl photoUrl;
    private Nationality nationality;

    public Player(PlayerId id, PlayerName name, PhotoUrl photoUrl, Nationality nationality) {
        this.id = Objects.requireNonNull(id, "Player id is required");
        this.name = Objects.requireNonNull(name, "Player name is required");
        this.photoUrl = photoUrl != null ? photoUrl : new PhotoUrl(null);
        this.nationality = Objects.requireNonNull(nationality, "Nationality is required");
    }

    public static Player create(PlayerName name, PhotoUrl photoUrl, Nationality nationality) {
        return new Player(new PlayerId(UUID.randomUUID()), name, photoUrl, nationality);
    }
    public void updateProfile(PlayerName name, PhotoUrl photoUrl, Nationality nationality) {
        this.name = Objects.requireNonNull(name, "Player name is required");
        this.photoUrl = photoUrl != null ? photoUrl : new PhotoUrl(null);
        this.nationality = Objects.requireNonNull(nationality, "Nationality is required");
    }

    public PlayerId getId() {
        return id;
    }

    public PlayerName getName() {
        return name;
    }

    public PhotoUrl getPhotoUrl() {
        return photoUrl;
    }

    public Nationality getNationality() {
        return nationality;
    }
}