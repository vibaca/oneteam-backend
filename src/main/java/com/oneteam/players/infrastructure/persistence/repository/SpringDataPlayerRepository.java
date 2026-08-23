package com.oneteam.players.infrastructure.persistence.repository;

import com.oneteam.players.infrastructure.persistence.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPlayerRepository extends JpaRepository<PlayerEntity, String> {
}