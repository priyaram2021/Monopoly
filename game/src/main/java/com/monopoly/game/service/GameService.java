package com.monopoly.game.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monopoly.game.DTO.ActionResponseDTO;
import com.monopoly.game.DTO.GameDTO;
import com.monopoly.game.DTO.PlayerDTO;
import com.monopoly.game.exception.GameNotFoundException;
import com.monopoly.game.exception.PlayerNotFoundException;
import com.monopoly.game.model.Game;
import com.monopoly.game.model.Player;
import com.monopoly.game.repository.GameRepository;
import com.monopoly.game.repository.PlaceRepository;
import com.monopoly.game.repository.PlayerRepository;

@Service
public class GameService {
	@Autowired
	private final GameRepository gameRepository;
	@Autowired
	private final PlayerRepository playerRepository;
	@Autowired
	private final PlaceRepository placeRepository;

	public GameService(GameRepository gameRepository, PlayerRepository playerRepository,
			PlaceRepository placeRepository) {
		this.gameRepository = gameRepository;
		this.playerRepository = playerRepository;
		this.placeRepository = placeRepository;
	}

	public GameDTO createGame() {
		Game game = new Game();
		gameRepository.save(game);

		return new GameDTO(game.getId());
	}

	public PlayerDTO joinGame(int gameId) throws GameNotFoundException {
		Optional<Game> optionalGame = gameRepository.findById(gameId);
		if (optionalGame.isPresent()) {
			Game game = optionalGame.get();
			Player player = new Player();
			player.setGame(game);
			player.setBalance(1000);
			player.setPosition(0);
			playerRepository.save(player);
			return new PlayerDTO(player.getId());
		} else {
			throw new GameNotFoundException("Game with ID " + gameId + " not found.");
		}
	}

	public ActionResponseDTO rollDie(int playerId) throws PlayerNotFoundException {
		Optional<Player> optionalPlayer = playerRepository.findById(playerId);
		if (optionalPlayer.isPresent()) {
			Player player = optionalPlayer.get();
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;
			int totalSteps = dice1 + dice2;
			player.setPosition((player.getPosition() + totalSteps) % 10);
			playerRepository.save(player);
			ActionResponseDTO response = new ActionResponseDTO();
			response.setDiceRollResult(dice1 + dice2);
			return response;
		} else {
			throw new PlayerNotFoundException("Player with ID " + playerId + " not found.");
		}
	}
}
