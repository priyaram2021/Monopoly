package com.monopoly.game.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Player> players;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Place> places;

	public Game() {
		super();
	}

	public Game(int id, List<Player> players, List<Place> places) {
		super();
		this.id = id;
		this.players = players;
		this.places = places;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

}
