package com.oneteam.players.infrastructure.out.persistence;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "players")
public class PlayerEntity {
    @Id
    private UUID id;
    private String name;
    private String photoUrl;
    private String nationalityName;
    private String nationalityIso;
    private String nationalityFlag;

    // JPA requiere constructor vacío
    protected PlayerEntity() {}

    public PlayerEntity(UUID id, String name, String photoUrl, String nationalityName, String nationalityIso, String nationalityFlag) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.nationalityName = nationalityName;
        this.nationalityIso = nationalityIso;
        this.nationalityFlag = nationalityFlag;
    }

    // Getters necesarios para el mapper
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getPhotoUrl() { return photoUrl; }
    public String getNationalityName() { return nationalityName; }
    public String getNationalityIso() { return nationalityIso; }
    public String getNationalityFlag() { return nationalityFlag; }
}