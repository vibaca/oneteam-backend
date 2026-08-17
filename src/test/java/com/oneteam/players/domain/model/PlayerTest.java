package com.oneteam.players.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Debe crear un jugador exitosamente cuando los datos son válidos")
    void shouldCreatePlayerSuccessfully() {
        // Arrange
        PlayerId id = PlayerId.generate();
        PlayerName name = new PlayerName("Lionel Messi");
        PhotoUrl photoUrl = new PhotoUrl("https://example.com/messi.png");
        Nationality nationality = new Nationality("Argentina", "AR", "https://flagcdn.com/ar.svg");

        // Act
        Player player = new Player(id, name, photoUrl, nationality);

        // Assert
        assertNotNull(player);
        assertEquals(id, player.getId());
        assertEquals("Lionel Messi", player.getName().value());
        assertEquals("https://example.com/messi.png", player.getPhotoUrl().value());
        assertEquals("Argentina", player.getNationality().name());
    }

    @Test
    @DisplayName("Debe fallar al intentar crear un jugador con un nombre vacío o en blanco")
    void shouldThrowExceptionWhenPlayerNameIsBlank() {
        // Arrange
        PlayerId id = PlayerId.generate();
        Nationality nationality = new Nationality("Argentina", "AR", "https://flagcdn.com/ar.svg");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Player(id, new PlayerName("   "), null, nationality)
        );

        assertEquals("Player name cannot be blank", exception.getMessage());
    }

    @Test
    @DisplayName("Debe fallar al intentar crear una Nacionalidad con un código ISO en blanco")
    void shouldThrowExceptionWhenIsoCodeIsBlank() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Nationality("Spain", "   ", "https://flagcdn.com/es.svg")
        );

        assertEquals("ISO code cannot be blank", exception.getMessage());
    }

    @Test
    @DisplayName("Debe actualizar el perfil del jugador correctamente")
    void shouldUpdatePlayerProfileSuccessfully() {
        // Arrange
        Player player = new Player(
                PlayerId.generate(),
                new PlayerName("Pedri González"),
                new PhotoUrl("https://example.com/pedri.png"),
                new Nationality("Spain", "ES", "https://flagcdn.com/es.svg")
        );

        PlayerName newName = new PlayerName("Pedro González");
        PhotoUrl newPhoto = new PhotoUrl("https://example.com/pedri-new.png");
        Nationality newNationality = new Nationality("Spain", "ES", "https://flagcdn.com/es.svg");

        // Act
        player.updateProfile(newName, newPhoto, newNationality);

        // Assert
        assertEquals("Pedro González", player.getName().value());
        assertEquals("https://example.com/pedri-new.png", player.getPhotoUrl().value());
    }
}