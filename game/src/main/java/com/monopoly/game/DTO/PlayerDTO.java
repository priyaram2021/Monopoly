package com.monopoly.game.DTO;

public class PlayerDTO {
	private int playerId;

    public PlayerDTO(int i) {
        this.playerId = i;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
