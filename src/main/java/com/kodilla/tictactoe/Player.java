package com.kodilla.tictactoe;

abstract class Player {

    private final String playerName;
    private final Mark playerMark;

    public Player(String playerName, Mark playerMark) {
        this.playerName = playerName;
        this.playerMark = playerMark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Mark getPlayerMark() {
        return playerMark;
    }

    protected abstract boolean getMove(Board board);

}
