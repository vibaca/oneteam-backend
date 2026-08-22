package com.oneteam.players.infrastructure.out.persistence;

import com.oneteam.players.domain.model.aggregate.Player;
import com.oneteam.players.domain.model.valueobjects.Nationality;
import com.oneteam.players.domain.model.valueobjects.PhotoUrl;
import com.oneteam.players.domain.model.valueobjects.PlayerId;
import com.oneteam.players.domain.model.valueobjects.PlayerName;
import com.oneteam.players.domain.repository.PlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaPlayerRepositoryAdapter implements PlayerRepository {

    private final SpringDataPlayerRepository repository;

    public JpaPlayerRepositoryAdapter(SpringDataPlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Player player) {
        PlayerEntity entity = new PlayerEntity(
                player.getId().value(),
                player.getName().value(),
                player.getPhotoUrl().valueOrNull(),
                player.getNationality().name(),
                player.getNationality().isoCode(),
                player.getNationality().flagUrl()
        );
        repository.save(entity);
    }

    @Override
    public Optional<Player> findById(PlayerId id) {
        return repository.findById(id.value()).map(entity -> new Player(
                new PlayerId(entity.getId()),
                new PlayerName(entity.getName()),
                new PhotoUrl(entity.getPhotoUrl()),
                new Nationality(entity.getNationalityName(), entity.getNationalityIso(), entity.getNationalityFlag())
        ));
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll().stream().map(entity -> new Player(
                new PlayerId(entity.getId()),
                new PlayerName(entity.getName()),
                new PhotoUrl(entity.getPhotoUrl()),
                new Nationality(entity.getNationalityName(), entity.getNationalityIso(), entity.getNationalityFlag())
        )).collect(Collectors.toList());
    }
}