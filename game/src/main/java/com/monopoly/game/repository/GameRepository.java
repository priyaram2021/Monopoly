package com.monopoly.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monopoly.game.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}

