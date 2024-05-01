package com.monopoly.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monopoly.game.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer>{

}
