package com.monopoly.game.DTO;

public class GameDTO {
	private int gameId;

    public GameDTO(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
