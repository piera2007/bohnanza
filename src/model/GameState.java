package model;

import java.util.List;

public class GameState {

    private List<Player> players;
    private int activePlayerIndex;

    private Deck drawPile;
    private Deck discardPile;

    public GameState(List<Player> players, Deck drawPile, Deck discardPile) {
        this.players = players;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.activePlayerIndex = 0;
    }

    public Player getActivePlayer() {
        return players.get(activePlayerIndex);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDrawPile() {
        return drawPile;
    }

    public Deck getDiscardPile() {
        return discardPile;
    }

    public int getActivePlayerIndex() {
        return activePlayerIndex;
    }

    public void nextPlayer() {
        activePlayerIndex = (activePlayerIndex + 1) % players.size();
    }
}