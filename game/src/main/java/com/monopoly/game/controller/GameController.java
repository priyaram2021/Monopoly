package com.monopoly.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monopoly.game.DTO.ActionResponseDTO;
import com.monopoly.game.DTO.GameDTO;
import com.monopoly.game.DTO.PlayerDTO;
import com.monopoly.game.exception.GameNotFoundException;
import com.monopoly.game.exception.PlayerNotFoundException;
import com.monopoly.game.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
	@Autowired
	private final GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@PostMapping("/create")
	public ResponseEntity<GameDTO> createGame() {
		GameDTO game = gameService.createGame();
		return new ResponseEntity<>(game, HttpStatus.CREATED);
	}

	@PostMapping("/join/{gameId}")
	public ResponseEntity<PlayerDTO> joinGame(@PathVariable int gameId) throws GameNotFoundException {
		PlayerDTO player = gameService.joinGame(gameId);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	@PostMapping("/roll-die/{playerId}")
	public ResponseEntity<ActionResponseDTO> rollDie(@PathVariable int playerId) throws PlayerNotFoundException {
		ActionResponseDTO response = gameService.rollDie(playerId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
