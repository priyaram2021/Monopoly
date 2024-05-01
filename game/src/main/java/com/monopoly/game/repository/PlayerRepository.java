package com.monopoly.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monopoly.game.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
