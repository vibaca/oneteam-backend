package com.oneteam.players.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "nationality_name")
    private String nationalityName;

    @Column(name = "iso_code")
    private String isoCode;

    @Column(name = "flag_url")
    private String flagUrl;

    public PlayerEntity() {}

    public PlayerEntity(String id, String name, String photoUrl, String nationalityName, String isoCode, String flagUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.nationalityName = nationalityName;
        this.isoCode = isoCode;
        this.flagUrl = flagUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}