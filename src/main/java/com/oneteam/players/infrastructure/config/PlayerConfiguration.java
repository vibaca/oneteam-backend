package com.oneteam.players.infrastructure.config;

import com.oneteam.players.application.mapper.PlayerResponseMapper;
import com.oneteam.players.application.query.FindAllPlayersQueryHandler;
import com.oneteam.players.application.port.out.PlayerQueryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfiguration {

    @Bean
    public PlayerResponseMapper playerResponseMapper() {
        return new PlayerResponseMapper();
    }

    @Bean
    public FindAllPlayersQueryHandler findAllPlayersQueryHandler(
            PlayerQueryOutputPort playerQueryOutputPort,
            PlayerResponseMapper playerResponseMapper
    ) {
        return new FindAllPlayersQueryHandler(playerQueryOutputPort, playerResponseMapper);
    }
}